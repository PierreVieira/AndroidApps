package com.example.firsttest.homework

object Fibonacci {

    /**
     * Returns the n-th fibonacci number
     * They are defined like this:
     * fib(0) = 0
     * fib(1) = 1
     * fib(n) = fib(n - 2) + fib(n - 1)
     * */
    fun fib(n: Int): Long {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        var a = 0L
        var b = 1L
        var c = 1L
        repeat(n - 1) {
            c = a + b
            a = b
            b = c
        }
        return c
    }
}