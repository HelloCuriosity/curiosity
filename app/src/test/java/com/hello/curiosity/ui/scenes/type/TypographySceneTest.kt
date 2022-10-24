package com.hello.curiosity.ui.scenes.type

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TypographySceneTest : ComposeTest() {
    @Test
    fun testColorScene() {
        composeTestRule.setContent {
            TypographyScene()
        }

        composeTestRule
            .onNodeWithTag("lazy-types-tag")
            .assertIsDisplayed()
    }
}
