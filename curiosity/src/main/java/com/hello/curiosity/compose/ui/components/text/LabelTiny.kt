package com.hello.curiosity.compose.ui.components.text

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelTiny(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.caption,
) = Text(
    text = text,
    modifier = modifier,
    color = color,
    textAlign = textAlign,
    style = style
)

@Composable
fun LabelTiny(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.caption,
) = Text(
    text = stringResource(id = text),
    modifier = modifier,
    color = color,
    textAlign = textAlign,
    style = style
)

@Preview
@Composable
internal fun LabelTinyPreview() {
    LabelTiny(text = "Tiny Label")
}