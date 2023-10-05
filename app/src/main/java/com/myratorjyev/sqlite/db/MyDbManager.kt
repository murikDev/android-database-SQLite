package com.myratorjyev.sqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.fragment.app.Fragment
import com.myratorjyev.sqlite.MainActivity
import com.myratorjyev.sqlite.ui.CreateFragment

class MyDbManager(context: Context) {

    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String){
        val values = ContentValues().apply {
            put(MyDbName.COLUMN_NAME_TITLE, title)
            put(MyDbName.COLUMN_NAME_CONTENT, content)
        }

        db?.insert(MyDbName.TABLE_NAME, null, values)
    }

    fun readDbData(): ArrayList<Post> {
        val listOfData = ArrayList<Post>()
        val cursor = db?.query(
            MyDbName.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor?.moveToNext()!!){
            val id = cursor.getLong(cursor.getColumnIndexOrThrow(BaseColumns._ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(MyDbName.COLUMN_NAME_TITLE))
            val content = cursor.getString(cursor.getColumnIndexOrThrow(MyDbName.COLUMN_NAME_CONTENT))

            listOfData.add(Post(id, title, content))
        }

        cursor.close()
        return listOfData
    }

    fun closeDb() {
        db?.close()
    }
}