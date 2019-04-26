package co.yello.db.batchlight

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BatchBinderTest {

    @MockK
    lateinit var binder: Binder

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    private val startIndex = sqlAndroidPreparedStatementStartIndex

    @Test
    fun `Test init clears bindings and sets position to 1`() {
        val binder = BatchBinder(binder, startIndex)
        verify { this@BatchBinderTest.binder.clear() }
        assertEquals(1, binder.currentBindIndex)
    }

    @Test
    fun `Test bindLong binds and increments the position` () {
        val binder = BatchBinder(binder, startIndex)
        binder.bindLong(1)
        binder.bindLong(2)
        binder.bindLong(3)

        verifyOrder {
            this@BatchBinderTest.binder.bindLong(1, 1)
            this@BatchBinderTest.binder.bindLong(2, 2)
            this@BatchBinderTest.binder.bindLong(3, 3)
        }

        assertEquals(4, binder.currentBindIndex)
    }

    @Test
    fun `Test bindNull binds and increments the position`() {
        val binder = BatchBinder(binder, startIndex)
        binder.bindNull()
        binder.bindNull()
        binder.bindNull()

        verifyOrder {
            this@BatchBinderTest.binder.bindNull(1)
            this@BatchBinderTest.binder.bindNull(2)
            this@BatchBinderTest.binder.bindNull(3)
        }

        assertEquals(4, binder.currentBindIndex)
    }

    @Test
    fun `Test bindDouble binds and increments the position`() {
        val binder = BatchBinder(binder, startIndex)
        binder.bindDouble(1.0)
        binder.bindDouble(2.0)
        binder.bindDouble(3.0)

        verifyOrder {
            this@BatchBinderTest.binder.bindDouble(1, 1.0)
            this@BatchBinderTest.binder.bindDouble(2, 2.0)
            this@BatchBinderTest.binder.bindDouble(3, 3.0)
        }

        assertEquals(4, binder.currentBindIndex)
    }

    @Test
    fun `Test bindString binds and increments the position`() {
        val binder = BatchBinder(binder, startIndex)
        binder.bindString("1")
        binder.bindString("2")
        binder.bindString("3")

        verifyOrder {
            this@BatchBinderTest.binder.bindString(1, "1")
            this@BatchBinderTest.binder.bindString(2, "2")
            this@BatchBinderTest.binder.bindString(3, "3")
        }

        assertEquals(4, binder.currentBindIndex)
    }

    @Test
    fun `Test bindBlob binds and increments the position`() {
        val binder = BatchBinder(binder, startIndex)

        val oneByte = ByteArray(1)
        val twoByte = ByteArray(2)
        val threeByte = ByteArray(3)

        binder.bindBlob(oneByte)
        binder.bindBlob(twoByte)
        binder.bindBlob(threeByte)

        verifyOrder {
            this@BatchBinderTest.binder.bindBlob(1, oneByte)
            this@BatchBinderTest.binder.bindBlob(2, twoByte)
            this@BatchBinderTest.binder.bindBlob(3, threeByte)
        }

        assertEquals(4, binder.currentBindIndex)
    }
}