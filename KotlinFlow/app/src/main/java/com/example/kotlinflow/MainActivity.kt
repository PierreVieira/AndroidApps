package com.example.kotlinflow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flow = flow {
            for (i in 1..10) {
                emit(i)
                delay(1000L)
            }
        }

        lifecycleScope.launch {
            flow
                .buffer()
                .filter {
                    it % 2 == 0
                }
                .map {
                   it * it
                }
                .collect {
                    Log.d(tag, "$it")
                    delay(2000L)
                }
        }
    }
}