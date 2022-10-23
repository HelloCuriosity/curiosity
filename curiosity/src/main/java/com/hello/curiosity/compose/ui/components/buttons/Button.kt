package com.hello.curiosity.compose.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hello.curiosity.compose.ui.theme.ThemeImpl

typealias action = () -> Unit

private val btnStyle = ThemeImpl.typography.h5.copy(fontSize = 18.sp)
private val btnShape = CircleShape
private val horizontalPadding = 25.dp
private val verticalPadding = 16.dp

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

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    onClick: action,
    enabled: Boolean = true,
    shape: Shape = btnShape,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    style: TextStyle = btnStyle,
    textModifier: Modifier = Modifier.padding(
        vertical = verticalPadding,
        horizontal = horizontalPadding,
    ),
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
fun TextIconButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @StringRes contentDescription: Int,
    @DrawableRes icon: Int,
    onClick: action,
    enabled: Boolean = true,
    shape: Shape = btnShape,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    style: TextStyle = btnStyle,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    textModifier: Modifier = Modifier.padding(
        top = verticalPadding,
        bottom = verticalPadding,
        end = horizontalPadding,
        start = 12.dp,
    ),
) = Button(
    modifier = modifier,
    shape = shape,
    onClick = onClick,
    enabled = enabled,
    colors = buttonColors,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.padding(start = horizontalPadding),
            painter = painterResource(id = icon),
            tint = tint,
            contentDescription = stringResource(id = contentDescription),
        )
        ButtonText(
            text = text,
            modifier = textModifier,
            style = style,
        )
    }
}

@Composable
private fun ButtonText(
    @StringRes text: Int,
    modifier: Modifier,
    style: TextStyle,
) = Text(
    text = stringResource(id = text),
    modifier = modifier,
    style = style,
)
