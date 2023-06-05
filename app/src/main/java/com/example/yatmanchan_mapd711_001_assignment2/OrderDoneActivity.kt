package com.example.yatmanchan_mapd711_001_assignment2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.yatmanchan_mapd711_001_assignment2.R.*

class OrderDoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_order_done)

        val confirmedModel = findViewById<TextView>(id.confirmedModel)
        val confirmedColor = findViewById<TextView>(id.confirmedColor)
        val confirmedStorage =findViewById<TextView>(id.confirmedStorage)

        // getting preferences
        val sharedPrefPhoneModel: SharedPreferences = this.getSharedPreferences("phoneModelPref", MODE_PRIVATE)
        val modelSelected = sharedPrefPhoneModel.getString("modelSelected", "")

        //get the preferences of the color and storage selected
        val sharedPrefColor: SharedPreferences = this.getSharedPreferences("colorPref", MODE_PRIVATE)
        val color = sharedPrefColor.getString("colorSelected", "")

        val sharedPrefStorage: SharedPreferences = this.getSharedPreferences("storagePref", MODE_PRIVATE)
        val storage = sharedPrefStorage.getString("storageSelected", "")

        confirmedModel.text = modelSelected.toString()
        confirmedColor.text = color.toString()
        confirmedStorage.text = storage.toString()

        val sharedPref: SharedPreferences = this.getSharedPreferences("MyPref", MODE_PRIVATE)

//        //spilt the storage and price
//        val storageAndPriceArray = storageAndPrice?.split(" ")
//        val storage = storageAndPriceArray?.get(0)
//        val price = storageAndPriceArray?.get(1)


        // get contact information
        val name = sharedPref.getString("name", "")
        val address = sharedPref.getString("address", "")
        val city = sharedPref.getString("city", "")
        val postalCode = sharedPref.getString("postalCode", "")
        val phoneNumber = sharedPref.getString("telephone", "")
        // get payment information
        val creditCard = sharedPref.getString("cardNumber", "")
        val cardType = sharedPref.getString("cardType", "")
        val expirationDate = sharedPref.getString("cardExpiry", "")
        val cvv = sharedPref.getString("cardCvv", "")


//        findViewById<TextView>(R.id.phonePrice).text = price

        findViewById<TextView>(R.id.confirmedCardHolderName).text = name
        findViewById<TextView>(R.id.confirmedAddress).text = address
        findViewById<TextView>(R.id.confirmedPostalCode).text = postalCode
        findViewById<TextView>(R.id.confirmedTel).text = phoneNumber
        findViewById<TextView>(R.id.confirmedCreditCard).text = creditCard
        findViewById<TextView>(R.id.confirmedExpire).text = expirationDate
        findViewById<TextView>(R.id.confirmedCVC).text = cvv
    }


}