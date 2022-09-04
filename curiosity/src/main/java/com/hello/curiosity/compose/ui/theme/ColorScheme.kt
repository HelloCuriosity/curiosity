package com.hello.curiosity.compose.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

@Suppress("MagicNumber")
data class ColorScheme(
    val primary: Color = Color(0xFF6650a4),
    val secondary: Color = Color(0xFF625b71),
    val tertiary: Color = Color(0xFF7D5260),

    val primaryDark: Color = Color(0xFFD0BCFF),
    val secondaryDark: Color = Color(0xFFCCC2DC),
    val tertiaryDark: Color = Color(0xFF7D5260),
) {

    fun toMaterialColors(isDark: Boolean) =
        if (isDark) darkColorPalette else lightColorPalette

    private val lightColorPalette = lightColors(
        primary = primary,
        secondary = secondary,
    )

    private val darkColorPalette = darkColors(
        primary = primaryDark,
        secondary = secondaryDark,
    )
}
