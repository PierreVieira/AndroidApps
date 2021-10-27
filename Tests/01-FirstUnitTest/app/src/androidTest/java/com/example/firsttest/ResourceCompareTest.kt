package com.example.firsttest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceCompareTest {
    private lateinit var resourceCompare: ResourceCompare
    private lateinit var context: Context

    @Before
    fun setup() {
        resourceCompare = ResourceCompare()
        context = ApplicationProvider.getApplicationContext()
    }

    @After
    fun teardown() {
        // e.g close db
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val result = resourceCompare.isEqual(context, R.string.app_name, "First Test")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val result = resourceCompare.isEqual(context, R.string.app_name, "Second Test")
        assertThat(result).isFalse()
    }
}