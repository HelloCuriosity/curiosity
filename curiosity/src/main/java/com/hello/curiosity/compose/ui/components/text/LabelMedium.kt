package com.hello.curiosity.compose.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelMedium(
    text: String,
) = Text(
    text = text,
    style = MaterialTheme.typography.h5
)

@Preview
@Composable
internal fun LabelMediumPreview() {
    LabelMedium(text = "Medium Label")
}
