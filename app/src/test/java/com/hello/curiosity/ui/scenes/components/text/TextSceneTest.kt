package com.hello.curiosity.ui.scenes.components.text

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class TextSceneTest : ComposeTest() {
    @Test
    fun testColorScene() {
        composeTestRule.setContent {
            TextScene()
        }

        composeTestRule
            .onNodeWithTag("text-scene-test-tag")
            .assertIsDisplayed()
    }
}
