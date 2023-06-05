package com.example.yatmanchan_mapd711_001_assignment2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.Objects

class SpecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spec)

        //defining a button reference object
        val submit = findViewById<View>(R.id.submit) as Button
        val spin = findViewById<View>(R.id.spinner) as Spinner
        //creating an intent object using both first and second activities.
        val i = Intent(this@SpecActivity, PersonalInfoActivity::class.java)

        // getting preferences of phone model
        val sharedPrefPhoneModel: SharedPreferences = this.getSharedPreferences("phoneModelPref", MODE_PRIVATE)
        val modelSelected = sharedPrefPhoneModel.getString("modelSelected", "")
        val selectedModel = findViewById<TextView>(R.id.selectedModel)
        selectedModel.text = modelSelected.toString()


        //handling radio buttons
        val group = findViewById<View>(R.id.radioGroup1) as RadioGroup
        group.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                val  selected_storage =  findViewById<View>(checkedId) as RadioButton
                val color = spin.selectedView as TextView
                if (selected_storage != null) {
                    submit.setOnClickListener {

                        //sending preferences of color and storage
                        val sharedColorPref: SharedPreferences= this.getSharedPreferences("colorPref", 0)
                        val editorColor:SharedPreferences.Editor =sharedColorPref.edit();
                        editorColor.putString("colorSelected", color.text.toString())
                        editorColor.commit()

                        val sharedStoragePref: SharedPreferences= this.getSharedPreferences("storagePref", 0)
                        val editorStorage:SharedPreferences.Editor =sharedStoragePref.edit();
                        editorStorage.putString("storageSelected", selected_storage.text.toString())
                        editorStorage.commit()


                        //defining a spinner reference object
                        //java reference object for edit text control
                        // val editText = findViewById<EditText>(R.id.editText)

                        //getting value from edit text and assign to string message
                        // val message = editText.text.toString()

                        //assigning value into intent object using key and values pairs.
                        i.putExtra("Message", color.text)
                        i.putExtra ("selectedStorage",  selected_storage.text )
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //starting sub activity
                        startActivity(i)
                    }
                }
            } else {
                Toast.makeText(this,"You must choose one" , Toast.LENGTH_SHORT).show()
            }
        }
        //event handler method for submit button
//        submit.setOnClickListener {
//            val color = spin.selectedView as TextView
////            val selected_color= color.text
////            { selected_color, confirmedStorage: String }
//
//
//            //defining a spinner reference object
//            //java reference object for edit text control
//            // val editText = findViewById<EditText>(R.id.editText)
//
//            //getting value from edit text and assign to string message
//            // val message = editText.text.toString()
//
//            //assigning value into intent object using key and values pairs.
//            i.putExtra("Message", color.text)
//            i.putExtra ("selectedStorage",  confirmedStorage )
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            //starting sub activity
//            startActivity(i)
//        }

    }


//    fun Submit_Click(v: View) {
//        //checking whether the button 1 is clicked or not
//        if (v.id == R.id.submit) {
//
//        //creating an intent object using both first and second activities.
//        val i = Intent(this@SpecActivity, PersonalInfoActivity::class.java)
//
//            //defining a spinner reference object
//            val spin = findViewById<View>(R.id.spinner) as Spinner
//            //java reference object for edit text control
//            // val editText = findViewById<EditText>(R.id.editText)
//
//
//            val color = spin.selectedView as TextView
////            val selected_color= color.text
//
//            //getting value from edit text and assign to string message
//            // val message = editText.text.toString()
//
//            //assigning value into intent object using key and values pairs.
//            i.putExtra("Message", color.text)
//
//            //starting sub activity
//            startActivity(i)
//
//        }
//    }
}