package io.github.hellocuriosity.compose.ui.components.input

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class InputTextFieldDefaultsTest : ComposeTest() {

    @Test
    fun testDefaultColors() {
        composeTestRule.setContent {
            val colors = InputTextFieldDefaults.colors()
            assertEquals(LocalContentColor.current.copy(LocalContentAlpha.current), colors.textColor)
            assertEquals(LocalContentColor.current.copy(LocalContentAlpha.current), colors.placeholderColor)
            assertEquals(MaterialTheme.colors.primary, colors.cursorColor)
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
            val colors = InputTextFieldDefaults.colors(
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
