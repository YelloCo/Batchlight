[batchlight](../../index.md) / [co.yello.db.batchlight](../index.md) / [BinderConfig](index.md) / [buildBinder](build-binder.md)

# buildBinder

`abstract fun buildBinder(insertCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../-binder/index.md)

Creates a [Binder](../-binder/index.md) that has the given number of bind locations.

### Parameters

`insertCount` - the number of fields that will be bound.

**Return**
a [Binder](../-binder/index.md) object that has [insertCount](build-binder.md#co.yello.db.batchlight.BinderConfig$buildBinder(kotlin.Int)/insertCount) number of fields

