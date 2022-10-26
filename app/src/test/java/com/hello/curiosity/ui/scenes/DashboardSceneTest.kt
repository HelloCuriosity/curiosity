package com.hello.curiosity.ui.scenes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class DashboardSceneTest : ComposeTest() {

    @Test
    fun testDashboardScene() {
        composeTestRule.setContent {
            DashboardScene()
        }

        // validate scaffold exists
        composeTestRule
            .onNodeWithTag("scaffold-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate app bar
        composeTestRule
            .onNodeWithTag("top-app-bar-test-tag")
            .assertDoesNotExist()

        // validate navigation exists
        composeTestRule
            .onNodeWithTag("navigation-test-tag")
            .assertExists()
            .assertIsDisplayed()
    }
}
