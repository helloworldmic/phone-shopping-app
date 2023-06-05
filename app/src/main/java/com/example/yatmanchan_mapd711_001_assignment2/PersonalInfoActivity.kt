package com.example.yatmanchan_mapd711_001_assignment2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.yatmanchan_mapd711_001_assignment2.R.id.storage_details

class PersonalInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)


        val intent = intent
        val message = intent.getStringExtra("Message")  //color selected
        val selectedStorage = intent.getStringExtra("selectedStorage")


        val textView = findViewById<TextView>(R.id.selected_spec)
        val storageDetails = findViewById<TextView>(storage_details)
        val modelSelected= findViewById<TextView>(R.id.model_selected)

        //get the preferences of the model selected
        val sharedPrefPhoneModel: SharedPreferences = this.getSharedPreferences("phoneModelPref", MODE_PRIVATE)
        val model = sharedPrefPhoneModel.getString("modelSelected", "")
        modelSelected.text = model.toString()


        textView.text = message  //color selected
        storageDetails.text = selectedStorage

        val k= Intent(this@PersonalInfoActivity, OrderDoneActivity::class.java)
        val cardholdername = findViewById<TextView>(R.id.cardHolderName)
        val add = findViewById<TextView>(R.id.add)
        val postalcode = findViewById<TextView>(R.id.postalcode)
        val tel = findViewById<TextView>(R.id.tel)
        val creditcardnum = findViewById<TextView>(R.id.creditcardnum)
        val expiration = findViewById<TextView>(R.id.expiration)
        val cvc = findViewById<TextView>(R.id.cvc)

        val submitOrder = findViewById<View>(R.id.confirmOrder) as Button
        submitOrder.setOnClickListener{
            if (cardholdername.text.toString().isEmpty() || add.text.toString().isEmpty() || postalcode.text.toString().isEmpty() || tel.text.toString().isEmpty() || creditcardnum.text.toString().isEmpty() || expiration.text.toString().isEmpty() || cvc.text.toString().isEmpty()) {
                Toast.makeText(this, "Please fill out all of the fields", Toast.LENGTH_LONG).show()
            }
            val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
            val editor2 = sharedPref.edit()
            editor2.putString("name", cardholdername.text.toString())
            editor2.putString("address", add.text.toString())
            editor2.putString("postalCode", postalcode.text.toString())
            editor2.putString("telephone", tel.text.toString())
            editor2.putString("cardNumber", creditcardnum.text.toString())
            editor2.putString("cardExpiry", expiration.text.toString())
            editor2.putString("cardCvv", cvc.text.toString())
            editor2.commit()

startActivity(k)
            }
        }
    }
