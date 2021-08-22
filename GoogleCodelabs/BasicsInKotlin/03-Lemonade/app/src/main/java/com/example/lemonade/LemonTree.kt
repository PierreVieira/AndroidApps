package com.example.lemonade

/**
 * A Lemon tree class with a method to "pick" a lemon. The "size" of the lemon is randomized
 * and determines how many times a lemon needs to be squeezed before you get lemonade.
 */
object LemonTree {
    fun pick() = (2..4).random()
}