package com.hello.curiosity.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.compose.ui.components.input.inputTextFieldColors
import com.hello.curiosity.compose.ui.theme.ColorScheme
import com.hello.curiosity.compose.ui.theme.Theme
import com.hello.curiosity.compose.ui.theme.Type

object AppTheme : Theme {
    override val typography: Type = Type()
    override val colors: ColorScheme = ColorScheme(
        background = Color(0xFFD0F4EA),
        primary = Color(0xFF087E8B),
        surface = Color(0xFF087E8B),
        onSurface = Color(0xFFD0F4EA),
        primaryVariant = Color(0xFFFF5A5F),

        backgroundDark = Color(0xFF3C3C3C),
        primaryDark = Color(0xFFD0F4EA),
        surfaceDark = Color(0xFFD0F4EA),
        onSurfaceDark = Color(0xFF087E8B),
        primaryVariantDark = Color(0xFFFF5A5F),
    )
}

@Composable
fun inputColors() = inputTextFieldColors(
    textColor = Color.Black,
    cursorColor = Color.Black,
)
