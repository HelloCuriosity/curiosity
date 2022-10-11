package com.hello.curiosity.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

abstract class ComposeTextTest : ComposeTest() {

    abstract val text: String
    abstract val content: @Composable () -> Unit

    @Test
    fun testText() {
        composeTestRule.setContent {
            content.invoke()
        }
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
    }
}
