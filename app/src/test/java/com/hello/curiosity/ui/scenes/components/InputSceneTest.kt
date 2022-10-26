package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertIsDisplayed
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
            .onNodeWithTag(testTag = "input-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()
    }
}
