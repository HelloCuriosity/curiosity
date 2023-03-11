package io.github.hellocuriosity.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

@Suppress("MagicNumber")
data class ColorScheme(
    val primary: Color = Color(0xFF6200EE),
    val primaryVariant: Color = Color(0xFF3700B3),
    val secondary: Color = Color(0xFF03DAC6),
    val secondaryVariant: Color = Color(0xFF018786),
    val background: Color = Color.White,
    val surface: Color = Color.White,
    val error: Color = Color(0xFFB00020),
    val onPrimary: Color = Color.White,
    val onSecondary: Color = Color.Black,
    val onBackground: Color = Color.Black,
    val onSurface: Color = Color.Black,
    val onError: Color = Color.White,

    val primaryDark: Color = Color(0xFFBB86FC),
    val primaryVariantDark: Color = Color(0xFF3700B3),
    val secondaryDark: Color = Color(0xFF03DAC6),
    val secondaryVariantDark: Color = secondary,
    val backgroundDark: Color = Color(0xFF121212),
    val surfaceDark: Color = Color(0xFF121212),
    val errorDark: Color = Color(0xFFCF6679),
    val onPrimaryDark: Color = Color.Black,
    val onSecondaryDark: Color = Color.Black,
    val onBackgroundDark: Color = Color.White,
    val onSurfaceDark: Color = Color.White,
    val onErrorDark: Color = Color.Black,
) {

    fun toMaterialColors(isDark: Boolean) =
        if (isDark) darkColorPalette else lightColorPalette

    private val lightColorPalette = lightColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        secondaryVariant = secondaryVariant,
        background = background,
        surface = surface,
        error = error,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onBackground = onBackground,
        onSurface = onSurface,
        onError = onError,
    )

    private val darkColorPalette = darkColors(
        primary = primaryDark,
        primaryVariant = primaryVariantDark,
        secondary = secondaryDark,
        secondaryVariant = secondaryVariantDark,
        background = backgroundDark,
        surface = surfaceDark,
        error = errorDark,
        onPrimary = onPrimaryDark,
        onSecondary = onSecondaryDark,
        onBackground = onBackgroundDark,
        onSurface = onSurfaceDark,
        onError = onErrorDark,
    )
}
