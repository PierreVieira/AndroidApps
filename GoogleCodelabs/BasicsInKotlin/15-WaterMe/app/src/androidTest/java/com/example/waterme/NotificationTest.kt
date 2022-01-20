package com.example.waterme

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class NotificationTest {

    companion object {
        private const val SETUP_TIMEOUT = 6000L
        private const val PLANT_NAME = "Carrot"
        private const val PACKAGE_NAME = "com.example.waterme"
    }

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var uiDevice: UiDevice

    @Before
    fun setup() {
        uiDevice = UiDevice.getInstance(getInstrumentation())
        onView(withText(PLANT_NAME)).perform(longClick())
        onView(withText("5 seconds")).perform(click())
        uiDevice.apply {
            pressHome()
            openNotification()
            wait(Until.hasObject(By.textContains(PLANT_NAME)), SETUP_TIMEOUT)
        }
    }

    @Test
    fun notification_scheduled() {
        val notification = uiDevice.findObject(UiSelector().textContains(PLANT_NAME)).exists()
        assertTrue("Could not find text '$PLANT_NAME'", notification)
        uiDevice.pressHome()
    }

    @Test
    fun notification_click() {
        val notification = uiDevice.findObject(UiSelector().textContains(PLANT_NAME))
        notification.click()
        uiDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME)
            .depth(0)), 1000)
        val pkg = uiDevice.findObject(UiSelector().packageName(PACKAGE_NAME))
            .exists()
        assertTrue("Could not find package", pkg)
    }
}
