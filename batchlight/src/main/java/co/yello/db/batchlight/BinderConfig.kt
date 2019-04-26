package co.yello.db.batchlight

/**
 * Holds all the configurations for a [Binder].
 */
interface BinderConfig {

    /**
     * Creates a [Binder] that has the given number of bind locations.
     *
     * @param insertCount the number of fields that will be bound.
     * @return a [Binder] object that has [insertCount] number of fields
     */
    fun buildBinder(insertCount: Int): Binder

    /**
     * Holds a reference to the max insert binder. This will be the most common case so it should
     * be cached.
     *
     * @return a [Binder] object that has maximum number of insert params available.
     */
    val maxInsertBinder: Binder

    /**
     * @return The start index of where to bind begin binding.
     */
    val startIndex: Int

    /**
     * If an object has 4 fields and only 3 should be written to the database this value should be set to 3.
     *
     * @return The number of fields to be inserted per item.
     */
    val fieldsPerItem: Int

    /**
     * @return The maximum number fields that can be bound at one time. For example this number is 999 for SQLite Android.
     */
    val maxFields: Int

    /**
     * @return The max number of items that can be inserted at one time.
     */
    val maxInsertSize: Int
}