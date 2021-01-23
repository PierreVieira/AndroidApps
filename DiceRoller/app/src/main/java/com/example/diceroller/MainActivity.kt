package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var imageDice: ImageView
    private lateinit var dice: Dice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAttributes()
        rollButton.setOnClickListener { rollDice() }
    }

    private fun initAttributes() {
        rollButton = findViewById(R.id.button)
        imageDice = findViewById(R.id.imageDice)
        dice = Dice(6)
    }

    private fun rollDice() {
        when(dice.roll()) {
            1 -> setContentImage(R.drawable.dice_1)
            2 -> setContentImage(R.drawable.dice_2)
            3 -> setContentImage(R.drawable.dice_3)
            4 -> setContentImage(R.drawable.dice_4)
            5 -> setContentImage(R.drawable.dice_5)
            else -> setContentImage(R.drawable.dice_6)
        }
    }

    private fun setContentImage(drawable: Int) {
        imageDice.setImageResource(drawable)
        imageDice.contentDescription = dice.toString()
    }
}