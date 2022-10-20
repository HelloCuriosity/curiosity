package com.hello.curiosity.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
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

        // validate text button exists and is clickable
        composeTestRule
            .onNodeWithTag(testTag = "button-scene-test-tag")
            .onChildAt(0)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
    }
}
