[batchlight](../../index.md) / [co.yello.db.batchlight.androidsqlite](../index.md) / [SQLiteBinderConfig](index.md)

# SQLiteBinderConfig

`class SQLiteBinderConfig : `[`BinderConfig`](../../co.yello.db.batchlight/-binder-config/index.md)

The [BinderConfig](../../co.yello.db.batchlight/-binder-config/index.md) for Android SQLite.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SQLiteBinderConfig(db: `[`SQLiteDatabase`](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)`, batchStatement: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, fieldsPerItem: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxFields: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [fieldsPerItem](fields-per-item.md) | `val fieldsPerItem: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>the number of fields per row to be inserted. |
| [maxFields](max-fields.md) | `val maxFields: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>the maximum number of binds that can happen per statement. |
| [maxInsertBinder](max-insert-binder.md) | `val maxInsertBinder: `[`Binder`](../../co.yello.db.batchlight/-binder/index.md)<br>Holds a reference to the max insert binder. This will be the most common case so it should be cached. |
| [maxInsertSize](max-insert-size.md) | `val maxInsertSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The maximum number of items that can be inserted per statement. |
| [startIndex](start-index.md) | `val startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [buildBinder](build-binder.md) | `fun buildBinder(insertCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../co.yello.db.batchlight/-binder/index.md)<br>Creates a [Binder](../../co.yello.db.batchlight/-binder/index.md) that has the given number of bind locations. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInsertConfig](get-insert-config.md) | `fun getInsertConfig(db: `[`SQLiteDatabase`](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)`, tableName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, columnCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxBinds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = sqlMaxBinds): `[`SQLiteBinderConfig`](index.md)<br>Creates a statement generator for batch insert statements. |
| [getReplaceConfig](get-replace-config.md) | `fun getReplaceConfig(db: `[`SQLiteDatabase`](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)`, tableName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, columnCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxBinds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = sqlMaxBinds): `[`SQLiteBinderConfig`](index.md)<br>Creates a statement generator for batch replace statements. |
