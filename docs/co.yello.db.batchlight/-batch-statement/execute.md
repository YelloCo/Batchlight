[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [BatchStatement](index.md) / [execute](execute.md)

# execute

`fun execute(itemsToInsert: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`T`](index.md#T)`>, bindItemFunction: `[`BatchBinder`](../-batch-binder/index.md)`.(`[`T`](index.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Chunks the list into the maximum sized list that can be inserted at a time, then executes the insert
with the [bindItemFunction](execute.md#co.yello.db.batchlight.BatchStatement$execute(kotlin.collections.Collection((co.yello.db.batchlight.BatchStatement.T)), kotlin.Function2((co.yello.db.batchlight.BatchBinder, co.yello.db.batchlight.BatchStatement.T, kotlin.Unit)))/bindItemFunction) passed into the class.

### Parameters

`itemsToInsert` - The collection of items of type [T](index.md#T) to batch insert into the database.

`bindItemFunction` -

A function that performs the binds for each field in the [T](index.md#T) passed to the function.
The function is an extension on [BatchBinder](../-batch-binder/index.md) so all bind functions can be accessed from within.



When binding the order of the bind calls should match the structure of the table inserting.



Example usage:



A simple class would look something like



```
data class BatchClass(val id: Int, val text: String, val num: Int)
```



The SQL Create statement for the corresponding table to that object would be:



```
CREATE TABLE BatchClass (
     id INTEGER,
     text TEXT,
     num INTEGER
)
```



The [Binder](../-binder/index.md) generated for this table will will have the params (?,?,?). To correctly bind the three values
to their correct ? in the prepared statement the function would be:



```
{ batchObject - >
     bindLong(batchObject.id)
     bindString(batchObject.text)
     bindLong(batchObject.num)
}
```

