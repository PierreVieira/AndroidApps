package com.example.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateImc()
        }
    }

    private fun calculateImc() {
        val weight = binding.editWeight.text.toString().toDoubleOrNull()
        val height = binding.editHeight.text.toString().toDoubleOrNull()
        if (weight != null && height != null) {
            val result = weight / (height * height)
            binding.result.text = String.format("%.2f", result)
        }
    }
}