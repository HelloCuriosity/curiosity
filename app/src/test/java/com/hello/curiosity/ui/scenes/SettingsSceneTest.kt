package com.hello.curiosity.ui.scenes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class SettingsSceneTest : ComposeTest() {

    @Test
    fun testSettingsScene() {
        composeTestRule.setContent {
            SettingsScene()
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate section exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(0)
            .assertExists()
            .assertIsDisplayed()

        // validate info exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(1)
            .assertExists()
            .assertIsDisplayed()

        // validate divider exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(2)
            .assertExists()
            .assertIsDisplayed()

        // validate privacy policy exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(3)
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate divider exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(4)
            .assertExists()
            .assertIsDisplayed()

        // validate github exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(5)
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate divider exists
        composeTestRule
            .onNodeWithTag(testTag = "settings-scene-test-tag")
            .onChildAt(6)
            .assertExists()
            .assertIsDisplayed()
    }
}
