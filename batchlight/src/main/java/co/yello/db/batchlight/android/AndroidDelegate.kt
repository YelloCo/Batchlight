package co.yello.db.batchlight.android

import co.yello.db.batchlight.sqlAndroidPreparedStatementStartIndex

class SqliteDelegate(
      fieldsPerItem: Int,
      maxFields: Int
) {
    /**
     * The maximum number of items that can be inserted per statement.
     */
    val maxInsertSize = if (fieldsPerItem > 0) maxFields / fieldsPerItem else 1

    /**
     * For a SQLite insert statement each item has the format (?, ?, ?)
     */
    val objectStatement = (1..fieldsPerItem).joinToString(
        prefix = "(",
        transform = { "?" },
        separator = ",",
        postfix= ")"
    )

    val startIndex: Int = sqlAndroidPreparedStatementStartIndex
}