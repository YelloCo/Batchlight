package co.yello.db.batchlight.androidsupportsqlite

import android.database.sqlite.SQLiteStatement
import androidx.sqlite.db.SupportSQLiteStatement
import co.yello.db.batchlight.androidsqlite.AndroidSQLiteBinder
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AndroidSupportSQLiteBinderTest {
    @MockK
    lateinit var compiledStatement: SupportSQLiteStatement

    private lateinit var androidSQLiteBinder: AndroidSupportSQLiteBinder

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        androidSQLiteBinder = AndroidSupportSQLiteBinder(compiledStatement)
    }

    @Test
    fun execute() {
        androidSQLiteBinder.execute()
        verify { compiledStatement.execute() }
    }

    @Test
    fun clearBindings() {
        androidSQLiteBinder.clear()
        verify { compiledStatement.clearBindings() }
    }

    @Test
    fun bindLong() {
        androidSQLiteBinder.bindLong(1, 1)
        verify { compiledStatement.bindLong(1, 1) }
    }

    @Test
    fun bindString() {
        androidSQLiteBinder.bindString(1, "")
        verify { compiledStatement.bindString(1, "") }
    }

    @Test
    fun bindDouble() {
        androidSQLiteBinder.bindDouble(1, 0.0)
        verify { compiledStatement.bindDouble(1, 0.0) }
    }

    @Test
    fun bindBlob() {
        val byteArray = ByteArray(1)
        androidSQLiteBinder.bindBlob(1, byteArray)
        verify { compiledStatement.bindBlob(1, byteArray) }
    }

    @Test
    fun bindNull() {
        androidSQLiteBinder.bindNull(1)
        verify { compiledStatement.bindNull(1) }
    }

    @Test
    fun testHashCode() {
        Assert.assertEquals(compiledStatement.hashCode(), androidSQLiteBinder.hashCode())
    }

    @Test
    fun `Test two AndroidSQLiteStatements with the same prepared statement are equal` () {
        Assert.assertEquals(androidSQLiteBinder, AndroidSupportSQLiteBinder(compiledStatement))
    }

    @Test
    fun `Test two AndroidSQLiteStatements with different prepared statement are equal` () {
        val compiledStatement2 = mockk<SQLiteStatement>()
        Assert.assertNotEquals(androidSQLiteBinder, AndroidSQLiteBinder(compiledStatement2))
    }
}