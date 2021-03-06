[batchlight](../../index.md) / [co.yello.db.batchlight.androidsupportsqlite](../index.md) / [SupportSQLiteBinderConfig](index.md) / [getInsertConfig](get-insert-config.md)

# getInsertConfig

`fun getInsertConfig(db: SupportSQLiteDatabase, tableName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, columnCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxBinds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = sqlMaxBinds): `[`SupportSQLiteBinderConfig`](index.md)

Creates a statement generator for batch insert statements.

### Parameters

`db` - the database to perform the insert on.

`tableName` - the name of the table to preform the insert on.

`columnCount` - the number of columns that will be insert per row.

`maxBinds` - the total number of values that can be bound to the statement.