package com.hello.curiosity.compose.ui.components.toggle

import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CheckBoxDefaults {
    @Composable
    fun colors(
        checkedColor: Color = MaterialTheme.colors.secondary,
        uncheckedColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        checkmarkColor: Color = MaterialTheme.colors.surface,
        disabledColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
        boarderColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
    ): CheckBoxColors = CheckBoxColors(
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
