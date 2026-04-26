package io.github.hellocuriosity.compose.ui.components.toggle

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CheckBoxDefaultsTest : ComposeTest() {
    @Test
    fun `validate CheckBoxDefaults colors() returns default values`() {
        composeTestRule.setContent {
            val colors = CheckBoxDefaults.colors()
            assertEquals(MaterialTheme.colorScheme.secondary, colors.checkedColor)
            assertEquals(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f), colors.uncheckedColor)
            assertEquals(MaterialTheme.colorScheme.surface, colors.checkmarkColor)
            assertEquals(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f), colors.disabledColor)
            assertEquals(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f), colors.boarderColor)
        }
    }

    @Test
    fun `validate CheckBoxDefaults custom colors() values`() {
        composeTestRule.setContent {
            val checkedColor = Color.Black
            val uncheckedColor = Color.Blue
            val checkmarkColor = Color.Cyan
            val disabledColor = Color.Magenta
            val boarderColor = Color.Red
            val colors =
                CheckBoxDefaults.colors(
                    checkedColor = checkedColor,
                    uncheckedColor = uncheckedColor,
                    checkmarkColor = checkmarkColor,
                    disabledColor = disabledColor,
                    boarderColor = boarderColor,
                )
            assertEquals(checkedColor, colors.checkedColor)
            assertEquals(uncheckedColor, colors.uncheckedColor)
            assertEquals(checkmarkColor, colors.checkmarkColor)
            assertEquals(disabledColor, colors.disabledColor)
            assertEquals(boarderColor, colors.boarderColor)
        }
    }
}
