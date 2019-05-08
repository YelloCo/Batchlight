[batchlight](../index.md) / [co.yello.db.batchlight](index.md)

## Package co.yello.db.batchlight

### Types

| Name | Summary |
|---|---|
| [BatchBinder](-batch-binder/index.md) | `class BatchBinder`<br>A wrapper around a [Binder](-binder/index.md) to make sure binds happen in sequential order. |
| [BatchStatement](-batch-statement/index.md) | `class BatchStatement<T>`<br>Drives the inserts into the database. |
| [Binder](-binder/index.md) | `interface Binder`<br>Provides way to bind values to any DB or ORM. |
| [BinderConfig](-binder-config/index.md) | `interface BinderConfig`<br>Holds all the configurations for a [Binder](-binder/index.md). |

### Properties

| Name | Summary |
|---|---|
| [sqlAndroidPreparedStatementStartIndex](sql-android-prepared-statement-start-index.md) | `const val sqlAndroidPreparedStatementStartIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The start index of Android SQLite prepared statement binds. |
| [sqlMaxBinds](sql-max-binds.md) | `const val sqlMaxBinds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The maximum number of bind params that Android SQLite allows per prepared statement. |
