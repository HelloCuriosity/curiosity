package com.hello.curiosity.ui.scenes.type

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Suppress("LongMethod")
fun TypographyScene() {
    val types =
        listOf(
            TypographyPresentation(title = "Display Large", style = MaterialTheme.typography.displayLarge),
            TypographyPresentation(title = "Display Medium", style = MaterialTheme.typography.displayMedium),
            TypographyPresentation(title = "Display Small", style = MaterialTheme.typography.displaySmall),
            TypographyPresentation(title = "Headline Large", style = MaterialTheme.typography.headlineLarge),
            TypographyPresentation(title = "Headline Medium", style = MaterialTheme.typography.headlineMedium),
            TypographyPresentation(title = "Headline Small", style = MaterialTheme.typography.headlineSmall),
            TypographyPresentation(title = "Title Large", style = MaterialTheme.typography.titleLarge),
            TypographyPresentation(title = "Title Medium", style = MaterialTheme.typography.titleMedium),
            TypographyPresentation(title = "Title Small", style = MaterialTheme.typography.titleSmall),
            TypographyPresentation(title = "Body Large", style = MaterialTheme.typography.bodyLarge),
            TypographyPresentation(title = "Body Medium", style = MaterialTheme.typography.bodyMedium),
            TypographyPresentation(title = "Body Small", style = MaterialTheme.typography.bodySmall),
            TypographyPresentation(title = "Label Large", style = MaterialTheme.typography.labelLarge),
            TypographyPresentation(title = "Label Medium", style = MaterialTheme.typography.labelMedium),
            TypographyPresentation(title = "Label Small", style = MaterialTheme.typography.labelSmall),
        )

    LazyColumn(
        modifier = Modifier.testTag("type-scene-test-tag"),
    ) {
        items(types) { type ->
            Text(
                modifier = Modifier.padding(8.dp),
                text = "${type.title}: The only way to go fast, is to go well. ~ Robert C. Martin",
                style = type.style,
            )
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
fun TypographyScenePreview() {
    TypographyScene()
}
