package com.hello.curiosity.curiosity.ui.scenes.type

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Suppress("LongMethod")
fun TypographyScene() {
    val types = listOf(
        TypographyPresentation(
            title = "H1",
            style = MaterialTheme.typography.h1
        ),
        TypographyPresentation(
            title = "H2",
            style = MaterialTheme.typography.h2
        ),
        TypographyPresentation(
            title = "H3",
            style = MaterialTheme.typography.h3
        ),
        TypographyPresentation(
            title = "H4",
            style = MaterialTheme.typography.h4
        ),
        TypographyPresentation(
            title = "H5",
            style = MaterialTheme.typography.h5
        ),
        TypographyPresentation(
            title = "H6",
            style = MaterialTheme.typography.h6
        ),
        TypographyPresentation(
            title = "Subtitle1",
            style = MaterialTheme.typography.subtitle1
        ),
        TypographyPresentation(
            title = "Subtitle2",
            style = MaterialTheme.typography.subtitle2
        ),
        TypographyPresentation(
            title = "Body1",
            style = MaterialTheme.typography.body1
        ),
        TypographyPresentation(
            title = "Body2",
            style = MaterialTheme.typography.body2
        ),
        TypographyPresentation(
            title = "Button",
            style = MaterialTheme.typography.button
        ),
        TypographyPresentation(
            title = "Caption",
            style = MaterialTheme.typography.caption
        ),
        TypographyPresentation(
            title = "Overline",
            style = MaterialTheme.typography.overline
        )
    )

    LazyColumn {
        items(types) { type ->
            Text(
                modifier = Modifier.padding(8.dp),
                text = "${type.title}: The only way to go fast, is to go well. ~ Robert C. Martin",
                style = type.style,
            )
            Divider()
        }
    }
}

@Preview
@Composable
fun TypographyScenePreview() {
    TypographyScene()
}
