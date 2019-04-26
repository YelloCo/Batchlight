package co.yello.db.batchinsertsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlin.system.measureTimeMillis
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener


class MainActivity : AppCompatActivity() {

    // A job that just tracks the database inserts. When the mainScopeJob is cancelled it will make the scope unusable
    // so we need this independent job to be able to start and stop the inserts without stopping all future inserts.
    private var dbInsertJob = Job()
    // This job is a parent job for all jobs ran within the mainScope. When this is cancelled all children are also
    // cancelled
    private val mainScopeJob: Job = Job()
    private val mainScope = CoroutineScope(mainScopeJob + Dispatchers.Main)

    private val databaseHelper: SQLiteHelper by lazy {
        SQLiteHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doInsertButton.setOnClickListener {
            executeInserts()
        }

        rowCount.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                if (event?.keyCode == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                    executeInserts()
                }
                return false
            }
        })
    }

    private fun executeInserts() {
        generateAndRun(rowCount.text.toString().ifBlank { "0" }.toInt())
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScopeJob.cancel()
    }

    /**
     * Helper function to generate a list of [MediumSizeObject].
     *
     * @param count the number of objects to put in the list.
     */
    private fun createMediumObjects(count: Int): List<MediumSizeObject> {
        val text = getString(R.string.static_text)
        val moreText = getString(R.string.more_static_text)

        return (1..count).map {
            MediumSizeObject(it, text, moreText)
        }
    }

    private suspend fun insertItems(items: List<MediumSizeObject>) = withContext(Dispatchers.Main) {
        Log.i(tag, "Starting individual insertion execution.")
        val time = measureTimeMillis {
            val channel = Channel<Int>(Channel.CONFLATED)

            launch {
                databaseHelper.loopInsert(channel, items)
                channel.close()
            }

            val progressPipeline = calcProgress(channel, insertsPerOnePercent(items.size))

            for (progress in progressPipeline) {
                single_time.text = getString(R.string.progress_percentage, progress)
            }
        }

        val executionTime = time/1000.0
        single_time.text = getString(R.string.single_insert_Time, executionTime)
        Log.i(tag, "Finished individual insertion execution in $executionTime seconds.")
    }

    private suspend fun batchInsertItems(items: List<MediumSizeObject>) {
        Log.i(tag, "Starting batch insertion execution.")
        batch_time.text = getString(R.string.inserting)
        val time = measureTimeMillis {
            databaseHelper.batchInsert(items)
        }

        val executionTime = time/1000.0
        batch_time.text = getString(R.string.batch_insert_time, executionTime)
        Log.i(tag, "Finished batch insertion execution in $executionTime seconds.")
    }

    private fun generateAndRun(size: Int) {
        insertionCountText.text = resources.getQuantityString(R.plurals.inserting_medium_objects, size, size)

        batch_time.text = getString(R.string.waiting_to_start)
        single_time.text = getString(R.string.waiting_to_start)

        // clears out potential existing transactions to restart the SQLite batch insertion job
        Log.i(tag, "Cancel $dbInsertJob")
        dbInsertJob.cancel()

        Log.i(tag, "Clearing Database")
        databaseHelper.clearDb()

        dbInsertJob = mainScope.launch {
            val list = createMediumObjects(size)

            insertItems(list)
            batchInsertItems(list)
        }
    }

    private fun insertsPerOnePercent(totalCount: Int) = if (totalCount <= 100) {
        1
    } else {
        totalCount / 100
    }

    companion object {
        const val tag = "Batch Insert Demo"
    }
}

@ExperimentalCoroutinesApi
fun CoroutineScope.calcProgress(
    insertCountChannel: ReceiveChannel<Int>,
    moduloValue: Int
): ReceiveChannel<Int> = produce {
    for (count in insertCountChannel) {
        if (count.rem(moduloValue) == 0) {
            send(count / moduloValue)
        }
    }
}
