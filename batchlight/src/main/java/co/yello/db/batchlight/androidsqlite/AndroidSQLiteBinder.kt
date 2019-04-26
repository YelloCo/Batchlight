package co.yello.db.batchlight.androidsqlite

import android.database.sqlite.SQLiteStatement
import co.yello.db.batchlight.Binder

/**
 * The [Binder] implementation for SQLite on Android.
 *
 * @property sqLiteStatement android SQLite statement to interact with.
 */
class AndroidSQLiteBinder(
    private val sqLiteStatement: SQLiteStatement
) : Binder {

    override fun execute() {
        sqLiteStatement.execute()
    }

    override fun clear() {
        sqLiteStatement.clearBindings()
    }

    override fun bindLong(position: Int, long: Long) {
        sqLiteStatement.bindLong(position, long)
    }

    override fun bindString(position: Int, string: String) {
        sqLiteStatement.bindString(position, string)
    }

    override fun bindDouble(position: Int, double: Double) {
        sqLiteStatement.bindDouble(position, double)
    }

    override fun bindBlob(position: Int, blob: ByteArray) {
        sqLiteStatement.bindBlob(position, blob)
    }

    override fun bindNull(position: Int) {
        sqLiteStatement.bindNull(position)
    }

    override fun equals(other: Any?): Boolean {
        return sqLiteStatement == (other as? AndroidSQLiteBinder)?.sqLiteStatement
    }

    override fun hashCode(): Int {
        return sqLiteStatement.hashCode()
    }
}