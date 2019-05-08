[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [BatchBinder](index.md)

# BatchBinder

`class BatchBinder`

A wrapper around a [Binder](../-binder/index.md) to make sure binds happen in sequential order.

### Parameters

`binder` - the specific [Binder](../-binder/index.md) to bind values to.

`startBindIndex` - the index to start binding to the binder.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BatchBinder(binder: `[`Binder`](../-binder/index.md)`, startBindIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>Creates a BatchBinder with the given binder. The binder will be cleared on creation to ensure no pre existing values will be bound unintentionally. |

### Properties

| Name | Summary |
|---|---|
| [currentBindIndex](current-bind-index.md) | `var currentBindIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Marks the current binding position. |

### Functions

| Name | Summary |
|---|---|
| [bindBlob](bind-blob.md) | `fun bindBlob(blob: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to the [Binder](../-binder/index.md) and increments the position. |
| [bindDouble](bind-double.md) | `fun bindDouble(double: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a value of type [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to the [Binder](../-binder/index.md) and increments the position. |
| [bindLong](bind-long.md) | `fun bindLong(long: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a value of type [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to the [Binder](../-binder/index.md) and increments the position. |
| [bindNull](bind-null.md) | `fun bindNull(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a null value to the [Binder](../-binder/index.md) and increments the bind position. |
| [bindString](bind-string.md) | `fun bindString(string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a value of type [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) to the [Binder](../-binder/index.md) and increments the position. |
