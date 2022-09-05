package com.hello.curiosity.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.text.LabelMedium

@Composable
fun ComponentScene() {
    val components = listOf(
        "Text",
        "Text",
        "Text",
        "Text",
        "Text",
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(components) { component ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                LabelMedium(text = component)
            }
        }
    }
}

@Preview
@Composable
fun ComponentScenePreview() {
    ComponentScene()
}
