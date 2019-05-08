[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [BatchStatement](index.md)

# BatchStatement

`class BatchStatement<T>`

Drives the inserts into the database.

### Parameters

`T` - The type of the collection that will be inserted. This is used to pass into the bind function that is
passed into the execute function.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BatchStatement(binderConfig: `[`BinderConfig`](../-binder-config/index.md)`)`<br>Drives the inserts into the database. |

### Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | `fun execute(itemsToInsert: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`T`](index.md#T)`>, bindItemFunction: `[`BatchBinder`](../-batch-binder/index.md)`.(`[`T`](index.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Chunks the list into the maximum sized list that can be inserted at a time, then executes the insert with the [bindItemFunction](execute.md#co.yello.db.batchlight.BatchStatement$execute(kotlin.collections.Collection((co.yello.db.batchlight.BatchStatement.T)), kotlin.Function2((co.yello.db.batchlight.BatchBinder, co.yello.db.batchlight.BatchStatement.T, kotlin.Unit)))/bindItemFunction) passed into the class. |
