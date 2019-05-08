[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [BinderConfig](index.md)

# BinderConfig

`interface BinderConfig`

Holds all the configurations for a [Binder](../-binder/index.md).

### Properties

| Name | Summary |
|---|---|
| [fieldsPerItem](fields-per-item.md) | `abstract val fieldsPerItem: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>If an object has 4 fields and only 3 should be written to the database this value should be set to 3. |
| [maxFields](max-fields.md) | `abstract val maxFields: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [maxInsertBinder](max-insert-binder.md) | `abstract val maxInsertBinder: `[`Binder`](../-binder/index.md)<br>Holds a reference to the max insert binder. This will be the most common case so it should be cached. |
| [maxInsertSize](max-insert-size.md) | `abstract val maxInsertSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [startIndex](start-index.md) | `abstract val startIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [buildBinder](build-binder.md) | `abstract fun buildBinder(insertCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../-binder/index.md)<br>Creates a [Binder](../-binder/index.md) that has the given number of bind locations. |

### Inheritors

| Name | Summary |
|---|---|
| [SQLiteBinderConfig](../../co.yello.db.batchlight.androidsqlite/-s-q-lite-binder-config/index.md) | `class SQLiteBinderConfig : `[`BinderConfig`](index.md)<br>The [BinderConfig](index.md) for Android SQLite. |
| [SupportSQLiteBinderConfig](../../co.yello.db.batchlight.androidsupportsqlite/-support-s-q-lite-binder-config/index.md) | `class SupportSQLiteBinderConfig : `[`BinderConfig`](index.md)<br>The [BinderConfig](index.md) for Android Support SQLite. |
