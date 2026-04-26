package com.hello.curiosity.ui.scenes.color

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Suppress("MagicNumber", "LongMethod")
internal fun ColorScene() {
    val colors =
        listOf(
            ColorPresentation(title = "Primary", color = MaterialTheme.colorScheme.primary),
            ColorPresentation(title = "On Primary", color = MaterialTheme.colorScheme.onPrimary),
            ColorPresentation(title = "Primary Container", color = MaterialTheme.colorScheme.primaryContainer),
            ColorPresentation(title = "On Primary Container", color = MaterialTheme.colorScheme.onPrimaryContainer),
            ColorPresentation(title = "Secondary", color = MaterialTheme.colorScheme.secondary),
            ColorPresentation(title = "On Secondary", color = MaterialTheme.colorScheme.onSecondary),
            ColorPresentation(title = "Secondary Container", color = MaterialTheme.colorScheme.secondaryContainer),
            ColorPresentation(title = "On Secondary Container", color = MaterialTheme.colorScheme.onSecondaryContainer),
            ColorPresentation(title = "Tertiary", color = MaterialTheme.colorScheme.tertiary),
            ColorPresentation(title = "On Tertiary", color = MaterialTheme.colorScheme.onTertiary),
            ColorPresentation(title = "Tertiary Container", color = MaterialTheme.colorScheme.tertiaryContainer),
            ColorPresentation(title = "On Tertiary Container", color = MaterialTheme.colorScheme.onTertiaryContainer),
            ColorPresentation(title = "Error", color = MaterialTheme.colorScheme.error),
            ColorPresentation(title = "On Error", color = MaterialTheme.colorScheme.onError),
            ColorPresentation(title = "Error Container", color = MaterialTheme.colorScheme.errorContainer),
            ColorPresentation(title = "On Error Container", color = MaterialTheme.colorScheme.onErrorContainer),
            ColorPresentation(title = "Background", color = MaterialTheme.colorScheme.background),
            ColorPresentation(title = "On Background", color = MaterialTheme.colorScheme.onBackground),
            ColorPresentation(title = "Surface", color = MaterialTheme.colorScheme.surface),
            ColorPresentation(title = "On Surface", color = MaterialTheme.colorScheme.onSurface),
            ColorPresentation(title = "Surface Variant", color = MaterialTheme.colorScheme.surfaceVariant),
            ColorPresentation(title = "On Surface Variant", color = MaterialTheme.colorScheme.onSurfaceVariant),
            ColorPresentation(title = "Outline", color = MaterialTheme.colorScheme.outline),
            ColorPresentation(title = "Scrim", color = MaterialTheme.colorScheme.scrim),
        )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.testTag("color-scene-test-tag"),
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
