package com.myratorjyev.sqlite.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.Fragment

class MyDbHelper(context: Context): SQLiteOpenHelper(context, MyDbName.DATEBASE_NAME, null, MyDbName.DATA_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDbName.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL(MyDbName.SQL_DELETE_TABLE)
        onCreate(db)
    }
}