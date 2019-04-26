package co.yello.db.batchlight.androidsqlite

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteStatement
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SQLiteBinderConfigTest {

    @MockK
    lateinit var sqLiteDatabase: SQLiteDatabase
    @MockK
    lateinit var compiledStatement: SQLiteStatement

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `Test maxInsertBinder returns a binder with the maximum number of binds`() {
        every { sqLiteDatabase.compileStatement("$insertSQL (?),(?)") } returns compiledStatement
        val generator = SQLiteBinderConfig(sqLiteDatabase,
            insertSQL, 1, 2)

        assertEquals(AndroidSQLiteBinder(compiledStatement), generator.maxInsertBinder)
    }

    @Test
    fun `Test generateBinder works with column size of 1`() {
        every { sqLiteDatabase.compileStatement("$insertSQL (?)") } returns compiledStatement

        val generator = SQLiteBinderConfig(sqLiteDatabase, insertSQL, 1, 2)

        assertEquals(AndroidSQLiteBinder(compiledStatement), generator.buildBinder(1))
    }

    @Test
    fun `Test generateStatement works with column size greater than 1`() {
        every { sqLiteDatabase.compileStatement("$insertSQL (?,?),(?,?)") } returns compiledStatement

        val generator = SQLiteBinderConfig(sqLiteDatabase,
            insertSQL, 2, 2)

        assertEquals(AndroidSQLiteBinder(compiledStatement), generator.buildBinder(2))
    }

    @Suppress("SyntaxError")
    @Test
    fun `Test getReplaceGenerator uses replace into to compile the query`() {
        val tableName = "MediumObjects"
        val expectedSql = "REPLACE INTO $tableName VALUES (?)"
        every { sqLiteDatabase.compileStatement(expectedSql) } returns compiledStatement

        SQLiteBinderConfig.getReplaceConfig(sqLiteDatabase, tableName, 1, 1).maxInsertBinder

        verify { sqLiteDatabase.compileStatement(expectedSql) }
    }

    @Test
    fun `Test getReplaceGenerator uses insert into to compile the query`() {
        val tableName = "MediumObjects"
        val expectedSql = "INSERT INTO $tableName VALUES (?)"
        every { sqLiteDatabase.compileStatement(expectedSql) } returns compiledStatement

        SQLiteBinderConfig.getInsertConfig(sqLiteDatabase, tableName, 1, 1).maxInsertBinder

        verify { sqLiteDatabase.compileStatement(expectedSql) }
    }

    companion object {
        private const val insertSQL = "INSERT INTO TABLE EXAMPLE"
    }
}