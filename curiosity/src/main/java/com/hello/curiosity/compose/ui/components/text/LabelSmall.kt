package com.hello.curiosity.compose.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
) = Text(
    text = text,
    modifier = modifier,
    textAlign = textAlign,
    style = MaterialTheme.typography.h6
)

@Preview
@Composable
internal fun LabelSmallPreview() {
    LabelSmall(text = "Small Label")
}
