package com.hello.curiosity.compose.ui.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.theme.ThemeImpl

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: action,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    style: TextStyle = ThemeImpl.typography.h5,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    childModifier: Modifier = Modifier
) = Button(
    modifier = modifier,
    shape = shape,
    onClick = onClick,
    enabled = enabled,
    colors = buttonColors,
) {
    Text(
        text = text,
        modifier = childModifier
            .padding(
                vertical = 16.dp,
                horizontal = 52.dp
            ),
        style = style,
    )
}
