package com.hello.curiosity.compose.ui.components.toggle

import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object ToggleDefaults {
    @Composable
    fun colors(
        checkedColor: Color = MaterialTheme.colors.secondary,
        uncheckedColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        toggleColor: Color = Color.White,
        disabledColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
        boarderColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
    ): ToggleColors = ToggleColors(
        checkedColor = checkedColor,
        uncheckedColor = uncheckedColor,
        toggleColor = toggleColor,
        disabledColor = disabledColor,
        boarderColor = boarderColor,
    )
}

data class ToggleColors(
    val checkedColor: Color,
    val uncheckedColor: Color,
    val boarderColor: Color,
    val toggleColor: Color,
    val disabledColor: Color,
)
