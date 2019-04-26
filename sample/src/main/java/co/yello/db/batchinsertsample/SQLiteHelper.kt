package co.yello.db.batchinsertsample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import co.yello.db.batchlight.BatchStatement
import co.yello.db.batchlight.androidsqlite.SQLiteBinderConfig
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel

class SQLiteHelper(context: Context) : SQLiteOpenHelper(
    context,
    databaseName,
    null,
    version
) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { /** no upgrades for now */ }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBatchTableStatement)
        db.execSQL(createSingleTableStatement)
    }

    /**
     * Uses Yello batch insert library to insert data into the database
     */
    suspend fun batchInsert(list: List<MediumSizeObject>) = withContext(Dispatchers.IO) {
        val binderConfig = SQLiteBinderConfig.getInsertConfig(
            db = writableDatabase,
            tableName = batchTableName,
            columnCount = 3
        )
        val statement = BatchStatement<MediumSizeObject>(binderConfig)

        writableDatabase.transaction {
            statement.execute(list) { mediumSizeObject ->
                bindLong(mediumSizeObject.id.toLong())
                bindString(mediumSizeObject.text)
                bindString(mediumSizeObject.moreText)
            }
        }
    }

    /**
     * Loops over collection of items and executes a insert for each item in the list
     */
    suspend fun loopInsert(progressChannel: SendChannel<Int>, list: List<MediumSizeObject>) = withContext(Dispatchers.IO) {
        val statement = writableDatabase.compileStatement(individualInsertStatement)

        writableDatabase.transaction {
            for ((index, mediumSizeObject) in list.withIndex()) {
                if (!isActive) {
                    System.out.println("Cancelling this transaction")
                    throw CancellationException()
                }

                progressChannel.send(index)

                with(statement) {
                    clearBindings()
                    bindLong(1, mediumSizeObject.id.toLong())
                    bindString(2, mediumSizeObject.text)
                    bindString(3, mediumSizeObject.moreText)
                    executeInsert()
                }
            }
        }
    }

    fun clearDb() {
        writableDatabase.transaction {
            delete(singleTableName, "", null)
            delete(batchTableName, "", null)
        }
    }

    companion object {
        const val singleTableName = "SingleInsertTable"
        const val batchTableName = "BatchInsertTable"
        private const val id = "id"
        private const val text = "text"
        private const val moreText = "moreText"

        const val databaseName = "batch_insert_demo.db"

        const val version = 1

        val createSingleTableStatement = """
            CREATE TABLE $singleTableName(
                $id INTEGER,
                $text TEXT,
                $moreText TEXT
            )""".trimIndent()

        val createBatchTableStatement = """
            CREATE TABLE $batchTableName(
                $id INTEGER,
                $text TEXT,
                $moreText TEXT
            )""".trimIndent()

        val individualInsertStatement = """
            INSERT INTO $singleTableName VALUES
            (?, ?, ?)
        """.trimIndent()
    }
}

/**
 * Run [body] in a transaction marking it as successful if it completes without exception.
 *
 * @param exclusive Run in `EXCLUSIVE` mode when true, `IMMEDIATE` mode otherwise.
 */
inline fun <T> SQLiteDatabase.transaction(
    exclusive: Boolean = true,
    body: SQLiteDatabase.() -> T
): T {
    if (exclusive) {
        beginTransaction()
    } else {
        beginTransactionNonExclusive()
    }
    try {
        val result = body()
        setTransactionSuccessful()
        return result
    } finally {
        endTransaction()
    }
}
