package com.example.tiptime

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TIP_AMOUNT_KEY = "tip_amount_key"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
        initializeTipAmount(savedInstanceState)
    }

    private fun initializeTipAmount(savedInstanceState: Bundle?) {
        binding.tipAmount.text = savedInstanceState?.getCharSequence(TIP_AMOUNT_KEY) ?: ""
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(TIP_AMOUNT_KEY, binding.tipAmount.text)
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        output(cost, tipPercentage)
    }

    private fun output(cost: Double?, tipPercentage: Double) {
        cost?.let { outputCost(it, tipPercentage) } ?: outputErrorToast()
        hiddenKeyboard()
    }

    private fun outputCost(cost: Double, tipPercentage: Double) {
        var tip = cost * tipPercentage
        if (binding.roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun outputErrorToast() {
        binding.tipAmount.text = ""
        Toast.makeText(this, R.string.invalid_input_data, Toast.LENGTH_SHORT).show()
    }

    private fun hiddenKeyboard() {
        val view = binding.costOfService.windowToken
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view, 0)
    }
}