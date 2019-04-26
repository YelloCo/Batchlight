package co.yello.db.batchlight

/**
 * Provides way to bind values to any DB or ORM.
 */
interface Binder {

    /**
     * Clears any bound values.
     */
    fun clear()

    /**
     * Executes with any bound values.
     */
    fun execute()

    /**
     * Binds a [Long] at the given position.
     *
     * @param position position to bind at.
     * @param long a value of type [Long] to bind.
     */
    fun bindLong(position: Int, long: Long)

    /**
     * Binds a [String] at the given position.
     *
     * @param position position to bind at.
     * @param string a value of type [String] to bind.
     */
    fun bindString(position: Int, string: String)

    /**
     * Binds a [Double] at the given position.
     *
     * @param position position to bind at.
     * @param double a value of type [Double] to bind.
     */
    fun bindDouble(position: Int, double: Double)

    /**
     * Binds a [ByteArray] at the given position.
     *
     * @param position position to bind at.
     * @param blob a value of type [ByteArray] to bind.
     */
    fun bindBlob(position: Int, blob: ByteArray)

    /**
     * Binds a null value at the given position.
     *
     * @param position position to bind at.
     */
    fun bindNull(position: Int)
}