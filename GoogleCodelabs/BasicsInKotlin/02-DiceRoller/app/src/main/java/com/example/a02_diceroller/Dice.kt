package com.example.a02_diceroller

class Dice {
    companion object {
        private const val SIDES = 6
    }

    fun roll() = (1..SIDES).random()
}