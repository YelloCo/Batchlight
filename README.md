Batch Light
=====

Batch Light is a library for batch inserting to SQLite on Android.

A demo project can be found on Google Play, and as an Instant App.

<a href='https://play.google.com/store/apps/details?id=com.ryancasler.db.batchinsertdemo&launch=true'>
<img alt='Demo Project on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height=90px/>
</a>

## Download

## Usage
Batch Lite has 4 main steps to use.

1. Create a configuration object. Currently SQLite is the only binder available with the batcher. 
The SQLiteBinderConfig has to default types available, Insert (INSERT INTO) and Replace (REPLACE INTO). When getting
an instance of the SQLiteBinderConfig there are three params. A reference to the SQLite Database being written to, 
the name of the table being written to and the number of columns that will be written to.

```kotlin
val binderConfig = SQLiteBinderConfig.getInsertConfig(
    db = writableDatabase,
    tableName = batchTableName,
    columnCount = 3
)
```

2. Create a new batcher using the config from step 1.

```kotlin
val batcher = BatchStatement<MediumSizeObject>(binderConfig)
```

3. call the execute function on the batcher, passing in the list to be inserted and a clojure that tells it how to bind 
the items in the list. The config will generate a statement that looks like:
      
```kotlin
data class InsertItem(val id: Int, val text: String)
```

Table structure:
```
TABLE_NAME
-----------
id | text | 
```

The generated SQLite for a list of 3 of the items above would be:

```roomsql
INSERT INTO TABLE_NAME VALUES (?, ?), (?, ?), (?, ?)
```

To bind the list, the closure below should be used. The binder will use the clojure for each item to bind to the generated 
statement.

```kotlin
batcher.execute(list) { listItem ->
    bindLong(listItem.id.toLong())
    bindString(listItem.text)
}
```

4. The Batch Lite does not handle transactions. It is left up to the end user to wrap the batch
insert into a transaction. If the list that is being batched is over 10,000 items it is recommended to chunk the list
and batch it in separate transactions to avoid blocking other inserts happening in the application. 

An example usage can be found in the sample project. 

Check out the [Kdoc](https://yelloco.github.io/Batchlight) for full documentation.

## Contributing

Please read [Contributing.md](CONTRIBUTING.md) for details on the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [License.txt](LICENSE.txt) file for details.

## Questions

Any questions comments or concerns can be directed to opensource@yello.co. 
