package com.hello.curiosity.ui.scenes.color

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class ColorSceneTest : ComposeTest() {

    @Test
    fun testColorScene() {
        composeTestRule.setContent {
            ColorScene()
        }

        composeTestRule
            .onNodeWithTag("color-scene-test-tag")
            .assertIsDisplayed()
    }
}
