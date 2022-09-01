package com.hello.curiosity.compose.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

@Suppress("MagicNumber")
data class Color(
    val primary: Color = Color(0xFF6650a4),
    val secondary: Color = Color(0xFF625b71),
    val tertiary: Color = Color(0xFF7D5260),

    val primaryDark: Color = Color(0xFFD0BCFF),
    val secondaryDark: Color = Color(0xFFCCC2DC),
    val tertiaryDark: Color = Color(0xFF7D5260),
) {

    fun toMaterialColors(isDark: Boolean) =
        if (isDark) darkColorPalette else lightColorPalette

    private val lightColorPalette: ColorScheme = lightColorScheme(
        primary = primary,
        secondary = secondary,
        tertiary = tertiary,
        /* Other default colors to override
        background = Color(0xFFFFFBFE),
        surface = Color(0xFFFFFBFE),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onTertiary = Color.White,
        onBackground = Color(0xFF1C1B1F),
        onSurface = Color(0xFF1C1B1F),
        */
    )

    private val darkColorPalette: ColorScheme = darkColorScheme(
        primary = primaryDark,
        secondary = secondaryDark,
        tertiary = tertiaryDark,
    )
}
