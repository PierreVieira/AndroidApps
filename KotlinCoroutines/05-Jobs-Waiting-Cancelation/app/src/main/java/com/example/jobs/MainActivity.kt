package com.example.jobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Default) {
            Log.d(tag, "Starting long running calculation...")
            withTimeout(3000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.d(tag, "Result for i = $i: ${fib(i)}")
                    }
                }
            }
            Log.d(tag, "Ending long running calculation...")
        }
    }

    private fun fib(n: Int): Long = when (n) {
        0 -> 0
        1 -> 1
        else -> fib(n - 1) + fib(n - 2)
    }
}