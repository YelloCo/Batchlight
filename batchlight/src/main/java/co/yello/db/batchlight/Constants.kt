@file:Suppress("SpellCheckingInspection")

package co.yello.db.batchlight

/**
 * The maximum number of bind params that Android SQLite allows per prepared statement.
 *
 * See SQLITE_MAX_VARIABLE_NUMBER in the SQLite docs at https://sqlite.org/limits.html
 */
const val sqlMaxBinds = 999

/**
 * The start index of Android SQLite prepared statement binds.
 */
const val sqlAndroidPreparedStatementStartIndex = 1
