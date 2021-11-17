package com.example.firsttest.homework

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciTest {

    @Test
    fun `fib(0) = 0`() {
        val result = Fibonacci.fib(0)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `fib(1) = 1`() {
        val result = Fibonacci.fib(1)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `fib(5) = 5`() {
        val result = Fibonacci.fib(5)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `fib(10) = 55`() {
        val result = Fibonacci.fib(10)
        assertThat(result).isEqualTo(55)
    }

    @Test
    fun `fib(15) = 610`() {
        val result = Fibonacci.fib(15)
        assertThat(result).isEqualTo(610)
    }
}