package com.example.yatmanchan_mapd711_001_assignment2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class SamsungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samsung)

        val listView: ListView = findViewById(R.id.phoneModelListView)

        val iphones = arrayOf<String>("iPhone14","iPhone14 Pro Max","iPhone14 Pro")

        val iPhoneList = ArrayList<String>(listOf(*iphones))  // StringArray

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, iPhoneList)

        val e = Intent(this@SamsungActivity, SpecActivity::class.java)

        listView.adapter = arrayAdapter
        val submitiPhoneModel = findViewById<View>(R.id.submitModel1)  //an obj
        listView.setOnItemClickListener { parent, _, position, _ ->
            val iphoneModelSelected = parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Selected item is $iphoneModelSelected", Toast.LENGTH_LONG).show()
            submitiPhoneModel.setOnClickListener {

                //sending preferences of the model selected
                val sharedPrefiPhone: SharedPreferences = this.getSharedPreferences("phoneModelPref", 0)
                val editor: SharedPreferences.Editor =sharedPrefiPhone.edit();
                editor.putString("modelSelected", iphoneModelSelected.toString())
                editor.commit()

                startActivity(e)
                e.putExtra("modelSelected", iphoneModelSelected)

            }
        }
    }
}