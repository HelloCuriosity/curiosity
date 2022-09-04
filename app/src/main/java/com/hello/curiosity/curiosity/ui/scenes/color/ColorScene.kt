package com.hello.curiosity.curiosity.ui.scenes.color

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Suppress("MagicNumber", "LongMethod")
internal fun ColorScene() {
    val colors = listOf(
        ColorPresentation(
            title = "Primary",
            color = MaterialTheme.colors.primary
        ),
        ColorPresentation(
            title = "Primary Variant",
            color = MaterialTheme.colors.primaryVariant
        ),
        ColorPresentation(
            title = "Secondary",
            color = MaterialTheme.colors.secondary
        ),
        ColorPresentation(
            title = "Secondary Variant",
            color = MaterialTheme.colors.secondaryVariant
        ),
        ColorPresentation(
            title = "Background",
            color = MaterialTheme.colors.background
        ),
        ColorPresentation(
            title = "Surface",
            color = MaterialTheme.colors.surface
        ),
        ColorPresentation(
            title = "Error",
            color = MaterialTheme.colors.error
        ),
        ColorPresentation(
            title = "On Primary",
            color = MaterialTheme.colors.onPrimary
        ),
        ColorPresentation(
            title = "On Secondary",
            color = MaterialTheme.colors.onSecondary
        ),
        ColorPresentation(
            title = "On Background",
            color = MaterialTheme.colors.onBackground
        ),
        ColorPresentation(
            title = "On Surface",
            color = MaterialTheme.colors.onSurface
        ),
        ColorPresentation(
            title = "On Error",
            color = MaterialTheme.colors.onError
        ),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(colors) { color ->
            ColorView(presentation = color)
        }
    }
}

@Preview
@Composable
internal fun ColorScenePreview() {
    ColorScene()
}
