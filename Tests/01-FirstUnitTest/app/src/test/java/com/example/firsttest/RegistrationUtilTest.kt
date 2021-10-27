package com.example.firsttest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Pierre",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }


    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirm password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Lucas",
            "1234",
            "1235"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Karol",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Goku",
            "oi eu sou o Goku 1",
            "oi eu sou o Goku 1"
        )
        assertThat(result).isFalse()
    }

    // empty password
    // password was repeated incorrectly
    // password contains less than 2 digits
}