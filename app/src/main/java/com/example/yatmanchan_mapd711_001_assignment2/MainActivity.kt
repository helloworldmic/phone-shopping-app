package com.example.yatmanchan_mapd711_001_assignment2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.differentlayouts, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent = Intent(this@MainActivity, PhoneModelActivity::class.java)
        val sharedPrefPhoneModel: SharedPreferences = this.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor3: SharedPreferences.Editor = sharedPrefPhoneModel.edit()

        when (item.itemId) {
            R.id.iPhone -> {
                editor3.putString("phoneBrand", "iPhone")
//                setContentView(R.layout.activity_iphone)
//                Toast.makeText(this, "iPhone.", Toast.LENGTH_LONG).show()
//                val a = Intent(this@MainActivity, IPhoneActivity::class.java)
//                startActivity(a)
            }
            R.id.Samsung -> {
                editor3.putString("phoneBrand", "Samsung")
//                setContentView(R.layout.activity_samsung)
//                Toast.makeText(this, "Samsung", Toast.LENGTH_LONG).show()
//                val b = Intent(this@MainActivity, SamsungActivity::class.java)
//                startActivity(b)
            }
            R.id.GooglePixel -> {
                editor3.putString("phoneBrand", "GooglePixel")
//                (R.layout.activity_google_pixel)
//                Toast.makeText(this, "Google Pixels", Toast.LENGTH_LONG).show()
//                val c = Intent(this@MainActivity, GooglePixelActivity::class.java)
//                startActivity(c)
            }
            R.id.Oppo -> {
                editor3.putString("phoneBrand", "Oppo")
//                setContentView(R.layout.activity_oppo)
//                Toast.makeText(this, "Oppo", Toast.LENGTH_LONG).show()
//                val a = Intent(this@MainActivity, OppoActivity::class.java)
//                startActivity(a)
            }
            R.id.choosespec -> {
                setContentView(R.layout.activity_spec)
                Toast.makeText(this, "Table Layout Example Code", Toast.LENGTH_LONG).show()
                val i = Intent(this@MainActivity, SpecActivity::class.java)
                startActivity(i)
            }
            R.id.personalinfo -> {
                setContentView(R.layout.activity_personal_info)
                Toast.makeText(this, "Table Layout Example Code", Toast.LENGTH_LONG).show()
                val j = Intent(this@MainActivity, PersonalInfoActivity::class.java)
                startActivity(j)
            }
            R.id.orderdone -> {
                setContentView(R.layout.activity_order_done)
                Toast.makeText(this, "Confirmed Order Page", Toast.LENGTH_LONG).show()
                val f = Intent(this@MainActivity, OrderDoneActivity::class.java)
                startActivity(f)
            }
        }
        editor3.commit()
        startActivity(intent)
        return true
    }

}