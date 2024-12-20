package io.github.hellocuriosity.compose.ui.components.input

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import io.github.hellocuriosity.compose.ui.theme.ThemeImpl

object InputTextFieldDefaults {
    @Composable
    fun colors(
        textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),
        placeholderColor: Color = textColor,
        cursorColor: Color = MaterialTheme.colors.primary,
        unfocusedIndicatorColor: Color = Color.Unspecified,
        focusedIndicatorColor: Color = Color.Unspecified,
        backgroundColor: Color = Color.Unspecified,
        boarderColor: Color = Color.Transparent,
    ): InputTextFieldColors =
        InputTextFieldColors(
            textColor = textColor,
            placeholderColor = placeholderColor,
            cursorColor = cursorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor,
            focusedIndicatorColor = focusedIndicatorColor,
            backgroundColor = backgroundColor,
            boarderColor = boarderColor,
        )
}

data class InputTextFieldColors(
    val textColor: Color,
    val placeholderColor: Color,
    val cursorColor: Color,
    val unfocusedIndicatorColor: Color,
    val focusedIndicatorColor: Color,
    val backgroundColor: Color,
    val boarderColor: Color,
)

internal val txtStyle = ThemeImpl.typography.h5.copy(fontSize = 18.sp)
