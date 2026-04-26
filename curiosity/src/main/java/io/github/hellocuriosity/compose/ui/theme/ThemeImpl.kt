package io.github.hellocuriosity.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

object ThemeImpl : Theme {
    override val typography: Type = Type()
    override val colors: ColorScheme = ColorScheme()
}

@Composable
fun CuriosityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    theme: Theme = ThemeImpl,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        content = content,
        typography = theme.typography.toMaterialTypography(),
        colorScheme = theme.colors.toMaterialColorScheme(darkTheme),
    )
}
