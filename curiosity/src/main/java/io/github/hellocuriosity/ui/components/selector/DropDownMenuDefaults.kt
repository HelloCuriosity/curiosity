package io.github.hellocuriosity.ui.components.selector

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object DropDownMenuDefaults {
    @Composable
    fun colors(
        backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        boarderColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
    ): DropDownMenuColors = DropDownMenuColors(
        backgroundColor = backgroundColor,
        boarderColor = boarderColor,
    )

    internal const val ONE_EIGHTY_DEGREES = 180f
    internal const val ZERO_DEGREES = 0f
}

data class DropDownMenuColors(
    val backgroundColor: Color,
    val boarderColor: Color,
)
