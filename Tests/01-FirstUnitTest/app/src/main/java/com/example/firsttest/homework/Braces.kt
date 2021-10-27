package com.example.firsttest.homework

object Braces {
    /**
     * Check if the braces are set correctly
     * e.g "(a * b))" should return false
     */
    fun checkBraces(string: String) : Boolean {
        var wasOpened = false
        string.forEach {
            if (it == '(') {
                wasOpened = true
            } else if (it == ')') {
                if (!wasOpened) {
                    return false
                }
            }
        }
        return string.count { it == '(' } == string.count { it == ')' }
    }
}