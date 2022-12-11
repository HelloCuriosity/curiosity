package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class InputSceneTest : ComposeTest() {

    @Test
    fun testInputScene() {
        composeTestRule.setContent {
            InputScene()
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_SCENE_VIEW_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate basic input text exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_SCENE_VIEW_TEST_TAG)
            .onChildAt(0)
            .assertExists()
            .assertIsDisplayed()

        // validate input text with placeholder exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_SCENE_VIEW_TEST_TAG)
            .onChildAt(1)
            .assertExists()
            .assertIsDisplayed()

        // validate input text with placeholder and counter exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_SCENE_VIEW_TEST_TAG)
            .onChildAt(2)
            .assertExists()
            .assertIsDisplayed()
    }
}
