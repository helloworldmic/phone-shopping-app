package com.example.yatmanchan_mapd711_001_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class PhoneModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_model)
        setupPhoneList()
        setupListItemClickEvent()

    }
fun setupPhoneList(){
    // use arrayAdapter and define an array
    val arrayAdapter: ArrayAdapter<*>
    //get phoneBrand from sharedPreference
    val sharedPref = getSharedPreferences("MyPref",MODE_PRIVATE)
    val phoneBrand = sharedPref.getString("phoneBrand","")
    var models = arrayOf("")

    if(phoneBrand == "iPhone"){
        //get string array from string.xml
        models = resources.getStringArray(R.array.iPhoneModels)
    }else if(phoneBrand == "Samsung"){
        models = resources.getStringArray(R.array.SamsungModels)
    }else if(phoneBrand == "Oppo"){
        models = resources.getStringArray(R.array.OppoModels)
    }else if(phoneBrand == "GooglePixel"){
        models = resources.getStringArray(R.array.GooglePixelModels)
    }

    // access the listView from xml file
    var mListView = findViewById<ListView>(R.id.phoneModelListView)
    arrayAdapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, models)
    mListView.adapter = arrayAdapter
}


    fun setupListItemClickEvent(){
        var mListView = findViewById<ListView>(R.id.phoneModelListView)
        val intent = Intent(this@PhoneModelActivity, SpecActivity::class.java)
        mListView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            //save selected phone model to sharedPreference
            val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("phoneModel", selectedItem)
            editor.commit()
            startActivity(intent)
        })
    }

}