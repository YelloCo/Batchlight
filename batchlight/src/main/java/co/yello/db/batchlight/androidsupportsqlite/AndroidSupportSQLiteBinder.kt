package co.yello.db.batchlight.androidsupportsqlite

import androidx.sqlite.db.SupportSQLiteStatement
import co.yello.db.batchlight.Binder

/**
 * The [Binder] implementation for Support SQLite on Android.
 *
 * @property sqLiteStatement A [SupportSQLiteStatement] to interact with.
 */
class AndroidSupportSQLiteBinder(
    private val sqLiteStatement: SupportSQLiteStatement
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
        return sqLiteStatement == (other as? AndroidSupportSQLiteBinder)?.sqLiteStatement
    }

    override fun hashCode(): Int {
        return sqLiteStatement.hashCode()
    }
}