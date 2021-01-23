package com.example.diceroller

class Dice(private val numSides: Int) {

    private var numberDrawn: Int = 0

    fun roll(): Int {
        numberDrawn = (1..6).random()
        return numberDrawn
    }

    override fun toString(): String {
        return "Dice with value $numberDrawn"
    }
}