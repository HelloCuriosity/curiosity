package com.hello.curiosity.compose.ui.components.buttons

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

typealias action = () -> Unit

@Composable
fun buttonColors(
    backgroundColor: Color,
    contentColor: Color,
    disabledBackgroundColor: Color,
    disabledContentColor: Color,
): ButtonColors = ButtonDefaults.buttonColors(
    backgroundColor = backgroundColor,
    contentColor = contentColor,
    disabledBackgroundColor = disabledBackgroundColor,
    disabledContentColor = disabledContentColor
)
