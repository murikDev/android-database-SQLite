package com.myratorjyev.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.myratorjyev.sqlite.databinding.ActivityMainBinding
import com.myratorjyev.sqlite.db.MyDbManager

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavMenu.setupWithNavController(
            navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        )

        MAIN = this
    }

//    override fun onResume() {
//        super.onResume()
//        val listOfData = myDbManager.readDbData()
//        for (item in listOfData) {
//            binding.tvSave.append("${item.id} - ${item.title} - ${item.content}")
//            binding.tvSave.append("\n")
//        }
//    }


//    override fun onDestroy() {
//        super.onDestroy()
//        myDbManager.closeDb()
//    }
}