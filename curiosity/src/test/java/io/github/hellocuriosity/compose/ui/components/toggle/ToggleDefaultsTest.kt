package io.github.hellocuriosity.compose.ui.components.toggle

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ToggleDefaultsTest : ComposeTest() {
    @Test
    fun `validate ToggleDefaults colors() returns default values`() {
        composeTestRule.setContent {
            val colors = ToggleDefaults.colors()
            assertEquals(MaterialTheme.colorScheme.secondary, colors.checkedColor)
            assertEquals(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f), colors.uncheckedColor)
            assertEquals(Color.White, colors.toggleColor)
            assertEquals(
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                colors.disabledColor,
            )
            assertEquals(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f), colors.boarderColor)
        }
    }

    @Test
    fun `validate ToggleDefaults custom colors() values`() {
        composeTestRule.setContent {
            val checkedColor = Color.Black
            val uncheckedColor = Color.Blue
            val toggleColor = Color.Cyan
            val disabledColor = Color.Magenta
            val boarderColor = Color.Red
            val colors =
                ToggleDefaults.colors(
                    checkedColor = checkedColor,
                    uncheckedColor = uncheckedColor,
                    toggleColor = toggleColor,
                    disabledColor = disabledColor,
                    boarderColor = boarderColor,
                )
            assertEquals(checkedColor, colors.checkedColor)
            assertEquals(uncheckedColor, colors.uncheckedColor)
            assertEquals(toggleColor, colors.toggleColor)
            assertEquals(disabledColor, colors.disabledColor)
            assertEquals(boarderColor, colors.boarderColor)
        }
    }
}
