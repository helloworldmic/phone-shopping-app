package com.example.yatmanchan_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.yatmanchan_mapd711_001_assignment2.R.*

class GooglePixelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_google_pixel)

        val listView: ListView = findViewById(id.googlepixellist)

        val googlePhones = arrayOf<String>("Google Pixel 6", "Google Pixel 6 Pro", "Google Pixel 6a" )

        val googlePhoneList = ArrayList<String>(listOf(*googlePhones))  // StringArray

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, googlePhoneList)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val listValue = parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Selected item is $listValue", Toast.LENGTH_LONG).show()
        }
    }
}