package com.example.a02_diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: AppCompatImageView
    private lateinit var buttonRoll: AppCompatButton
    private val dice = Dice()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        getRandomImage()
        setupButtonClick()
    }

    private fun findViews() {
        diceImage = findViewById(R.id.image)
        buttonRoll = findViewById(R.id.button)
    }

    private fun getRandomImage() {
        val imageId = getImageId()
        diceImage.setImageDrawable(ContextCompat.getDrawable(this, imageId))
    }

    private fun setupButtonClick() {
        buttonRoll.setOnClickListener {
            getRandomImage()
        }
    }

    private fun getImageId() = when (dice.roll()) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> throw IllegalStateException("Impossible dice value")
    }
}