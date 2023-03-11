package io.github.hellocuriosity.compose.ui.components.selector

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class DropDownMenuDefaultsTest : ComposeTest() {

    @Test
    fun `validate DropDownMenuDefaults colors() return default values`() {
        composeTestRule.setContent {
            val colors = DropDownMenuDefaults.colors()
            assertEquals(MaterialTheme.colors.onSurface.copy(alpha = 0.1f), colors.backgroundColor)
            assertEquals(MaterialTheme.colors.onSurface.copy(alpha = 0.2f), colors.boarderColor)
        }
    }

    @Test
    fun `validate DropDownMenuDefaults custom colors() values`() {
        composeTestRule.setContent {
            val backgroundColor = Color.Blue
            val boarderColor = Color.Cyan
            val colors = DropDownMenuDefaults.colors(
                backgroundColor = backgroundColor,
                boarderColor = boarderColor,
            )
            assertEquals(backgroundColor, colors.backgroundColor)
            assertEquals(boarderColor, colors.boarderColor)
        }
    }
}
