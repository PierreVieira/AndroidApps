package com.example.runblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "Before runBlocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(2000L)
                Log.d(tag, "Finished IO Coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(2000L)
                Log.d(tag, "Finished IO Coroutine 2")
            }
            Log.d(tag, "Start of runBlocking")
            delay(5000L)
            Log.d(tag, "End of runBlocking")
        }
        Log.d(tag, "After runBlocking")
    }
}