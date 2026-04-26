package io.github.hellocuriosity.compose.ui.components.input

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class InputTextFieldDefaultsTest : ComposeTest() {
    @Test
    fun testDefaultColors() {
        composeTestRule.setContent {
            val colors = InputTextFieldDefaults.colors()
            assertEquals(LocalContentColor.current, colors.textColor)
            assertEquals(LocalContentColor.current, colors.placeholderColor)
            assertEquals(MaterialTheme.colorScheme.primary, colors.cursorColor)
            assertEquals(Color.Unspecified, colors.unfocusedIndicatorColor)
            assertEquals(Color.Unspecified, colors.focusedIndicatorColor)
            assertEquals(Color.Unspecified, colors.backgroundColor)
            assertEquals(Color.Transparent, colors.boarderColor)
        }
    }

    @Test
    fun testCustomColors() {
        composeTestRule.setContent {
            val textColor = Color.Black
            val placeholderColor = Color.Blue
            val cursorColor = Color.Cyan
            val unfocusedIndicatorColor = Color.Magenta
            val focusedIndicatorColor = Color.Red
            val backgroundColor = Color.DarkGray
            val boarderColor = Color.LightGray
            val colors =
                InputTextFieldDefaults.colors(
                    textColor = textColor,
                    placeholderColor = placeholderColor,
                    cursorColor = cursorColor,
                    unfocusedIndicatorColor = unfocusedIndicatorColor,
                    focusedIndicatorColor = focusedIndicatorColor,
                    backgroundColor = backgroundColor,
                    boarderColor = boarderColor,
                )
            assertEquals(textColor, colors.textColor)
            assertEquals(placeholderColor, colors.placeholderColor)
            assertEquals(cursorColor, colors.cursorColor)
            assertEquals(unfocusedIndicatorColor, colors.unfocusedIndicatorColor)
            assertEquals(focusedIndicatorColor, colors.focusedIndicatorColor)
            assertEquals(backgroundColor, colors.backgroundColor)
            assertEquals(boarderColor, colors.boarderColor)
        }
    }
}
