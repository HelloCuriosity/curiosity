package com.hello.curiosity.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object Theme {
    val typography: Type
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val colors: Color
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val paddings: Padding
        @Composable
        @ReadOnlyComposable
        get() = LocalAppPaddings.current
}

val LocalAppTypography = staticCompositionLocalOf { Type() }
val LocalAppColors = staticCompositionLocalOf { Color() }
val LocalAppPaddings = staticCompositionLocalOf { Padding() }

@Composable
fun CuriosityTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        content = content,
        typography = Theme.typography.toMaterialTypography(),
        colorScheme = Theme.colors.toMaterialColors(darkTheme),
    )
}
