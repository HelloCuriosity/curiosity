package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class ButtonSceneTest : ComposeTest() {

    @Test
    fun testButtonScene() {
        composeTestRule.setContent {
            ButtonScene()
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate enabled text button exists and is enabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(0)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled()

        // validate disabled text button exists and is disabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(1)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsNotEnabled()

        // validate enabled text icon button exists and is enabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(2)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled()

        // validate disabled text icon button exists and is disabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(3)
            .performClick()
            .assertHasClickAction()
            .assertIsNotEnabled()

        // validate enabled icon button exists and is enabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(4)
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled()

        // validate disabled icon button exists and is disabled
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .performScrollToIndex(5)
            .onChildAt(5)
            .performClick()
            .assertHasClickAction()
            .assertIsNotEnabled()
    }
}
