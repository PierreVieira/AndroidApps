package com.example.lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LEMONADE_STATE = "LEMONADE_STATE"
        private const val LEMON_SIZE = "LEMON_SIZE"
        private const val SQUEEZE_COUNT = "SQUEEZE_COUNT"

        private const val SELECT = "select"

        private const val SQUEEZE = "squeeze"

        private const val DRINK = "drink"

        private const val RESTART = "restart"
        private const val DEFAULT_INITIAL_VALUE = -1
    }

    private var lemonadeState = SELECT

    private var lemonSize = DEFAULT_INITIAL_VALUE

    private var squeezeCount = DEFAULT_INITIAL_VALUE

    private lateinit var lemonImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeSavedInstanceDependencies(savedInstanceState)
        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        setupClicks()
    }

    private fun initializeSavedInstanceDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, DEFAULT_INITIAL_VALUE)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, DEFAULT_INITIAL_VALUE)
        }
    }

    private fun setViewElements() {
        val textAction: TextView = findViewById(R.id.text_action)
        @StringRes val textId: Int
        @DrawableRes val drawableId: Int
        when (lemonadeState) {
            SELECT -> {
                textId = R.string.lemon_select
                drawableId = R.drawable.lemon_tree
            }
            SQUEEZE -> {
                textId = R.string.lemon_squeeze
                drawableId = R.drawable.lemon_squeeze
            }
            DRINK -> {
                textId = R.string.lemon_drink
                drawableId = R.drawable.lemon_drink
            }
            RESTART -> {
                textId = R.string.lemon_empty_glass
                drawableId = R.drawable.lemon_restart
            }
            else -> throw myException()
        }
        textAction.text = getString(textId)
        lemonImage.setImageResource(drawableId)
    }

    private fun setupClicks() {
        lemonImage.setOnClickListener {
            clickLemonImage()
        }
        lemonImage.setOnLongClickListener {
            showSnackbar()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putInt(LEMON_SIZE, lemonSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    private fun clickLemonImage() {
        lemonadeState = when (lemonadeState) {
            SELECT -> {
                lemonSize = LemonTree.pick()
                squeezeCount = 0
                SQUEEZE
            }
            SQUEEZE -> {
                ++squeezeCount
                --lemonSize
                if (lemonSize == 0) DRINK else SQUEEZE
            }
            DRINK -> RESTART
            RESTART -> SELECT
            else -> throw myException()
        }
        setViewElements()
    }

    private fun myException() = IllegalArgumentException("$lemonadeState is a invalid state.")

    private fun showSnackbar() = if (lemonadeState == SQUEEZE) {
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        getSnackBar(squeezeText).show()
        false
    } else true

    private fun getSnackBar(squeezeText: String) = Snackbar.make(
        findViewById(R.id.constraint_Layout),
        squeezeText,
        Snackbar.LENGTH_SHORT
    )
}
