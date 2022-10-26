package com.hello.curiosity.ui.scenes.type

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class TypographySceneTest : ComposeTest() {
    @Test
    fun testColorScene() {
        composeTestRule.setContent {
            TypographyScene()
        }

        composeTestRule
            .onNodeWithTag("type-scene-test-tag")
            .assertIsDisplayed()
    }
}
