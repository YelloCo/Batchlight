[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [Binder](index.md)

# Binder

`interface Binder`

Provides way to bind values to any DB or ORM.

### Functions

| Name | Summary |
|---|---|
| [bindBlob](bind-blob.md) | `abstract fun bindBlob(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, blob: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) at the given position. |
| [bindDouble](bind-double.md) | `abstract fun bindDouble(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, double: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) at the given position. |
| [bindLong](bind-long.md) | `abstract fun bindLong(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, long: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) at the given position. |
| [bindNull](bind-null.md) | `abstract fun bindNull(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a null value at the given position. |
| [bindString](bind-string.md) | `abstract fun bindString(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) at the given position. |
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clears any bound values. |
| [execute](execute.md) | `abstract fun execute(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Executes with any bound values. |

### Inheritors

| Name | Summary |
|---|---|
| [AndroidSQLiteBinder](../../co.yello.db.batchlight.androidsqlite/-android-s-q-lite-binder/index.md) | `class AndroidSQLiteBinder : `[`Binder`](index.md)<br>The [Binder](index.md) implementation for SQLite on Android. |
| [AndroidSupportSQLiteBinder](../../co.yello.db.batchlight.androidsupportsqlite/-android-support-s-q-lite-binder/index.md) | `class AndroidSupportSQLiteBinder : `[`Binder`](index.md)<br>The [Binder](index.md) implementation for Support SQLite on Android. |
