[batchlight](../../index.md) / [co.yello.db.batchlight.androidsupportsqlite](../index.md) / [SupportSQLiteBinderConfig](index.md) / [getReplaceConfig](get-replace-config.md)

# getReplaceConfig

`fun getReplaceConfig(db: SupportSQLiteDatabase, tableName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, columnCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxBinds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = sqlMaxBinds): `[`SupportSQLiteBinderConfig`](index.md)

Creates a statement generator for batch replace statements.

### Parameters

`db` - the database to perform the replaces on.

`tableName` - the name of the table to preform the replaces on.

`columnCount` - the number of columns that will be replaced per row.

`maxBinds` - the total number of values that can be bound to the statement.