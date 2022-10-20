package com.hello.curiosity.curiosity

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComponentActivityTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest : ComponentActivityTest<MainActivity>() {

    @Test
    fun testActivityExists() {
        ActivityScenario.launch<MainActivity>(
            Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        ).use { scenario ->
            activityScenario = scenario
            rule.onNodeWithTag("dashboard-scaffold-tag")
                .assertExists()
                .assertIsDisplayed()
        }
    }
}
