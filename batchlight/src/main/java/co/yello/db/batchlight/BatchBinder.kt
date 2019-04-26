package co.yello.db.batchlight

/**
 * A wrapper around a [Binder] to make sure binds happen in sequential order.
 *
 * @param binder the specific [Binder] to bind values to.
 * @param startBindIndex the index to start binding to the binder.
 *
 * @constructor Creates a BatchBinder with the given binder. The binder will be cleared on creation to ensure
 * no pre existing values will be bound unintentionally.
 */
class BatchBinder(
    private val binder: Binder,
    startBindIndex: Int
) {

    /**
     * Marks the current binding position.
     */
    var currentBindIndex: Int = startBindIndex
        private set

    init {
        binder.clear()
    }

    /**
     * Binds a value of type [Long] to the [Binder] and increments the position.
     *
     * @param long a [Long] to be bound to the [Binder]
     */
    fun bindLong(long: Long) {
        binder.bindLong(currentBindIndex++, long)
    }

    /**
     * Binds a value of type [String] to the [Binder] and increments the position.
     *
     * @param string a [String] to be bound to the [Binder].
     */
    fun bindString(string: String) {
        binder.bindString(currentBindIndex++, string)
    }

    /**
     * Binds a value of type [Double] to the [Binder] and increments the position.
     *
     * @param double a [Double] to be bound to the [Binder].
     */
    fun bindDouble(double: Double) {
        binder.bindDouble(currentBindIndex++, double)
    }

    /**
     * Binds a null value to the [Binder] and increments the bind position.
     */
    fun bindNull() {
        binder.bindNull(currentBindIndex++)
    }

    /**
     * Binds a [ByteArray] to the [Binder] and increments the position.
     *
     * @param blob a [ByteArray] to be bound to the [Binder].
     */
    fun bindBlob(blob: ByteArray) {
        binder.bindBlob(currentBindIndex++, blob)
    }
}