package com.example.firsttest.homework

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BracesTest {
    @Test
    fun `close first returns false`() {
        val result = Braces.checkBraces(")(a + b)(")
        assertThat(result).isFalse()
    }

    @Test
    fun `different amount braces returns false`() {
        val result = Braces.checkBraces("((a + b)")
        assertThat(result).isFalse()
    }

    @Test
    fun `same amount braces returns false`() {
        val result = Braces.checkBraces("(a + b)")
        assertThat(result).isTrue()
    }
}