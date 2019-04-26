package co.yello.db.batchlight

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class BatchStatementTest {

    @MockK
    lateinit var maxBinder: Binder

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `Test bindEmptyList does nothing`() {
        val binderConfig = mockBinderConfig(0)

        val batchStatement = BatchStatement<TestObject>(binderConfig)

        batchStatement.execute(listOf()) { }

        verify { listOf(maxBinder) wasNot called }
    }

    @Test
    fun `Test execute max statement`() {
        val binderConfig = mockBinderConfig(1)

        val batchStatement = BatchStatement<TestClass>(binderConfig)

        val insertCount = maxInsertSize
        val list = mutableListOf<TestClass>()
        for (i in 1..insertCount) { list.add(TestClass(i)) }

        batchStatement.execute(list) {item ->
            bindLong(item.id.toLong())
        }

        verifyOrder {
            for (i  in 1..insertCount/ maxInsertSize) {
                binderConfig.maxInsertBinder
                maxBinder.execute()
            }
        }
    }

    @Test
    fun `Test execute with list size max + 1`() {
        val statement = mockk<Binder>(relaxUnitFun = true)
        val columnCount = 1

        val binderConfig = mockBinderConfig(columnCount, 2)
        every { binderConfig.buildBinder(any()) } returns statement


        val batchStatement = BatchStatement<TestClass>(binderConfig)

        // 2 of the inserts will use the max binder and the last insert will need a new binder
        val insertCount = 5
        val list = mutableListOf<TestClass>()
        for (i in 1..insertCount) { list.add(TestClass(i)) }

        batchStatement.execute(list) { item ->
            bindLong(item.id.toLong())
        }

        verifyOrder {
            for (i  in 1..insertCount/ (maxInsertSize/columnCount)) {
                binderConfig.maxInsertBinder
                maxBinder.execute()
            }
            binderConfig.buildBinder(insertCount.rem(maxInsertSize))
            statement.execute()
        }
    }

    @Test
    fun `Test binder lambda gets executed`() {
        val binderConfig = mockBinderConfig(1)

        val batchStatement = BatchStatement<TestClass>(binderConfig)

        val insertCount = 2
        val list = mutableListOf<TestClass>()
        for (i in 1..insertCount) { list.add(TestClass(i)) }

        batchStatement.execute(list) {
            bindLong(it.id.toLong())
        }

        verifyOrder {
            for (i  in 1..insertCount/ maxInsertSize) {
                binderConfig.maxInsertBinder
                maxBinder.bindLong(1, i*2L-1)
                maxBinder.bindLong(2, i*2L)
                maxBinder.execute()
            }
        }
    }

    @Test(expected = IllegalStateException::class)
    fun `Test too many binds in the lambda throws exception`() {
        val binderConfig = mockBinderConfig(0, 1)

        val batchStatement = BatchStatement<TestObject>(binderConfig)

        batchStatement.execute(mutableListOf(TestObject)) {
            bindLong(1)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun `Test too few binds in the lambda throws exception`() {
        val binderConfig = mockBinderConfig(1, 1)

        val batchStatement = BatchStatement<TestClass>(binderConfig)

        batchStatement.execute(mutableListOf(TestClass(1))) {}
    }

    private fun mockBinderConfig(fieldsPer: Int, maxInsert: Int = maxInsertSize) = mockk<BinderConfig>().apply {
            every { maxInsertBinder } returns maxBinder
            every { fieldsPerItem } returns fieldsPer
            every { maxInsertSize } returns maxInsert
            every { startIndex } returns 1
        }

    companion object {
        private const val maxInsertSize = 2
    }

    object TestObject
    data class TestClass(val id: Int)
}
