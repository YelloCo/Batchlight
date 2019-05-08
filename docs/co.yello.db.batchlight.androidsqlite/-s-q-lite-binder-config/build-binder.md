[batchlight](../../index.md) / [co.yello.db.batchlight.androidsqlite](../index.md) / [SQLiteBinderConfig](index.md) / [buildBinder](build-binder.md)

# buildBinder

`fun buildBinder(insertCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../co.yello.db.batchlight/-binder/index.md)

Overrides [BinderConfig.buildBinder](../../co.yello.db.batchlight/-binder-config/build-binder.md)

Creates a [Binder](../../co.yello.db.batchlight/-binder/index.md) that has the given number of bind locations.

### Parameters

`insertCount` - the number of fields that will be bound.

**Return**
a [Binder](../../co.yello.db.batchlight/-binder/index.md) object that has [insertCount](../../co.yello.db.batchlight/-binder-config/build-binder.md#co.yello.db.batchlight.BinderConfig$buildBinder(kotlin.Int)/insertCount) number of fields

