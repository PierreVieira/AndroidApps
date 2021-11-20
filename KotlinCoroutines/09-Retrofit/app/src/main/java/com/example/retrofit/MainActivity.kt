package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            val response = api
                .getComments()
            if (response.isSuccessful) {
                val comments = response.body()
                comments?.forEach {
                    Log.d(tag, it.toString())
                }
            }
        }
    }
}