package com.example.asyncawait

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = async { networkCall(1) }
                val answer2 = async { networkCall(2) }
                Log.d(tag, "Answer1 is ${answer1.await()}")
                Log.d(tag, "Answer2 is ${answer2.await()}")
            }
            Log.d(tag, "Requests took $time ms.")
        }
    }

    private suspend fun networkCall(index: Int): String {
        delay(3000L)
        return "answer $index"
    }
}