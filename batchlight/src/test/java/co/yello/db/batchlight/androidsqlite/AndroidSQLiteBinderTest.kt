package co.yello.db.batchlight.androidsqlite

import android.database.sqlite.SQLiteStatement
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class AndroidSQLiteBinderTest {
    @MockK
    lateinit var compiledStatement: SQLiteStatement

    private lateinit var androidSQLiteBinder: AndroidSQLiteBinder

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
       androidSQLiteBinder = AndroidSQLiteBinder(compiledStatement)
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
        assertEquals(compiledStatement.hashCode(), androidSQLiteBinder.hashCode())
    }

    @Test
    fun `Test two AndroidSQLiteStatements with the same prepared statement are equal` () {
        assertEquals(androidSQLiteBinder, AndroidSQLiteBinder(compiledStatement))
    }

    @Test
    fun `Test two AndroidSQLiteStatements with different prepared statement are equal` () {
        val compiledStatement2 = mockk<SQLiteStatement>()
        assertNotEquals(androidSQLiteBinder, AndroidSQLiteBinder(compiledStatement2))
    }
}