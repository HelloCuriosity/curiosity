package com.hello.curiosity.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.compose.ui.components.input.inputTextFieldColors
import com.hello.curiosity.compose.ui.theme.ColorScheme
import com.hello.curiosity.compose.ui.theme.Theme
import com.hello.curiosity.compose.ui.theme.Type

object AppTheme : Theme {
    override val typography: Type = Type()
    override val colors: ColorScheme = ColorScheme()
}

@Composable
fun inputColors() = inputTextFieldColors(
    textColor = Color.Black,
    cursorColor = Color.Black,
)
