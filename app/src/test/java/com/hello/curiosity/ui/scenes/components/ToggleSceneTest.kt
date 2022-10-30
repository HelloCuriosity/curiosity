package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class ToggleSceneTest : ComposeTest() {

    @Test
    fun testToggleScene() {
        composeTestRule.setContent {
            ToggleScene()
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag(testTag = "toggle-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate toggle exists
        composeTestRule
            .onNodeWithTag(testTag = "toggle-scene-test-tag")
            .onChildAt(0)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled()

        // validate checkbox exists
        composeTestRule
            .onNodeWithTag(testTag = "toggle-scene-test-tag")
            .onChildAt(1)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled()
    }
}
