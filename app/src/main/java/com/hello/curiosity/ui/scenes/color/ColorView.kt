package com.hello.curiosity.ui.scenes.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.tools.Exclude

@Composable
internal fun ColorView(
    presentation: ColorPresentation
) = Column(
    modifier = Modifier.padding(8.dp)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = presentation.color
            )
    )

    Text(text = presentation.title)
}

@Exclude
@Preview
@Composable
internal fun ColorViewPreview() {
    ColorView(
        presentation = ColorPresentation(
            title = "Primary",
            color = MaterialTheme.colors.primary
        )
    )
}
