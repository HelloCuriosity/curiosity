package com.hello.curiosity.compose.ui.components.buttons

import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.hello.curiosity.compose.ui.theme.ThemeImpl
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TextButtonTest : ComposeTest() {

    private val text = "Text button"

    @Test
    fun testDefaultTextButton() {
        composeTestRule.setContent {
            TextButton(
                text = text,
                onClick = { },
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
    }

    @Test
    fun testCustomTextButton() {
        composeTestRule.setContent {
            TextButton(
                text = text,
                modifier = Modifier,
                onClick = { },
                enabled = false,
                shape = RectangleShape,
                style = ThemeImpl.typography.h1,
                buttonColors = buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Cyan,
                    disabledBackgroundColor = Color.Magenta,
                    disabledContentColor = Color.Yellow,
                ),
                childModifier = Modifier,
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
    }
}
