package io.github.hellocuriosity.compose.ui.components.toggle

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CheckBoxDefaults {
    @Composable
    fun colors(
        checkedColor: Color = MaterialTheme.colorScheme.secondary,
        uncheckedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
        checkmarkColor: Color = MaterialTheme.colorScheme.surface,
        disabledColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        boarderColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    ): CheckBoxColors =
        CheckBoxColors(
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor,
            checkmarkColor = checkmarkColor,
            disabledColor = disabledColor,
            boarderColor = boarderColor,
        )
}

data class CheckBoxColors(
    val checkedColor: Color,
    val uncheckedColor: Color,
    val boarderColor: Color,
    val checkmarkColor: Color,
    val disabledColor: Color,
)
