package com.example.suspend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(tag, networkCallAnswer)
            Log.d(tag, networkCallAnswer2)
        }
    }

    private suspend fun doNetworkCall() : String {
        delay(3000L)
        return "This is the answer"
    }

    private suspend fun doNetworkCall2() : String {
        delay(3000L)
        return "This is the answer 2"
    }
}