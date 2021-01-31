package com.example.tiptime

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {calculateTip()}
    }

    private fun calculateTip () {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        output(cost, tipPercentage)
    }

    private fun output(cost: Double?, tipPercentage: Double) {
        if (cost != null) {
            outputCost(cost, tipPercentage)
        } else {
            outputErrorToast()
        }
        hiddenKeyboard()
    }

    private fun outputCost(cost: Double, tipPercentage: Double) {
        var tip = cost * tipPercentage
        if (binding.roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun outputErrorToast() {
        binding.tipResult.text = ""
        Toast.makeText(this, R.string.invalid_input_data, Toast.LENGTH_SHORT).show()
    }

    private fun hiddenKeyboard() {
        val view = binding.costOfService.windowToken
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view, 0)
    }
}