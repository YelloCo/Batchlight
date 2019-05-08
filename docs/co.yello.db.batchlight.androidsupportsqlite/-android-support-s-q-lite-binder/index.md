[batchlight](../../index.md) / [co.yello.db.batchlight.androidsupportsqlite](../index.md) / [AndroidSupportSQLiteBinder](index.md)

# AndroidSupportSQLiteBinder

`class AndroidSupportSQLiteBinder : `[`Binder`](../../co.yello.db.batchlight/-binder/index.md)

The [Binder](../../co.yello.db.batchlight/-binder/index.md) implementation for Support SQLite on Android.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AndroidSupportSQLiteBinder(sqLiteStatement: SupportSQLiteStatement)`<br>The [Binder](../../co.yello.db.batchlight/-binder/index.md) implementation for Support SQLite on Android. |

### Functions

| Name | Summary |
|---|---|
| [bindBlob](bind-blob.md) | `fun bindBlob(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, blob: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) at the given position. |
| [bindDouble](bind-double.md) | `fun bindDouble(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, double: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) at the given position. |
| [bindLong](bind-long.md) | `fun bindLong(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, long: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) at the given position. |
| [bindNull](bind-null.md) | `fun bindNull(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a null value at the given position. |
| [bindString](bind-string.md) | `fun bindString(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) at the given position. |
| [clear](clear.md) | `fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clears any bound values. |
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [execute](execute.md) | `fun execute(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Executes with any bound values. |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
