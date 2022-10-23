package com.hello.curiosity.compose.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hello.curiosity.compose.ui.theme.ThemeImpl

@Composable
fun TextButton(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    onClick: action,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    style: TextStyle = ThemeImpl.typography.h5.copy(
        fontSize = 18.sp,
    ),
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    textModifier: Modifier = Modifier,
) = Button(
    modifier = modifier,
    shape = shape,
    onClick = onClick,
    enabled = enabled,
    colors = buttonColors,
) {
    ButtonText(
        text = text,
        modifier = textModifier,
        style = style,
    )
}

@Composable
private fun ButtonText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    style: TextStyle,
) = Text(
    text = stringResource(id = text),
    modifier = modifier
        .padding(
            vertical = 16.dp,
            horizontal = 28.dp,
        ),
    style = style,
)
