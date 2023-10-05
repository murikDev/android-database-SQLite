package com.myratorjyev.sqlite

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.myratorjyev.sqlite.db.MyDbManager
import com.myratorjyev.sqlite.db.Post

class MainViewModel(application: Application) : AndroidViewModel(application){

    val myDbManager = MyDbManager(getApplication())

    init {
        myDbManager.openDb()
    }

    fun insertDataToDb(title: String, content: String) {
        myDbManager.insertToDb(title, content)
        val toast = Toast.makeText(getApplication(), "Data saved successfully!", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun readData(): ArrayList<Post> {
        return myDbManager.readDbData()
    }


}