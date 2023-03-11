package com.hello.curiosity.ui.scenes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class DashboardSceneTest : ComposeTest() {

    @Test
    fun testDashboardScene() {
        composeTestRule.setContent {
            DashboardScene()
        }

        // validate scaffold exists
        composeTestRule
            .onNodeWithTag(DASHBOARD_SCENE_VIEW_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate app bar exists
        composeTestRule
            .onNodeWithTag(DASHBOARD_SCENE_TOP_APP_BAR_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate navigation exists
        composeTestRule
            .onNodeWithTag(DASHBOARD_SCENE_NAVIGATION_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
    }
}
