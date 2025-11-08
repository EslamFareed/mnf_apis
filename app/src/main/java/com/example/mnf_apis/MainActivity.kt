package com.example.mnf_apis

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        GlobalScope.launch {
//
//            runOnUiThread {
//
//            }
//
//        }

        val tv = findViewById<TextView>(R.id.tv)
        val pB = findViewById<ProgressBar>(R.id.pB)

        // Activity Closed // Connection for any calling is destroyed
        lifecycleScope.launch {
            val response =  RetrofitInstance.api.getProducts()

            Log.d("products_response",response.code().toString())
            Log.d("products_response",response.isSuccessful.toString())
            Log.d("products_response",response.body().toString())

            runOnUiThread {
                pB.visibility = GONE
                if (response.isSuccessful){
                    tv.text = "${response.body()!!.size} Products Found"
                }else{
                    tv.text = "Api is error"
                }
            }



        }

    }
}