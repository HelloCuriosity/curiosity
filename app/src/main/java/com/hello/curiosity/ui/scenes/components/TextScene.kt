package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.Exclude
import io.github.hellocuriosity.compose.ui.components.text.ContentLarge
import io.github.hellocuriosity.compose.ui.components.text.ContentMedium
import io.github.hellocuriosity.compose.ui.components.text.LabelLarge
import io.github.hellocuriosity.compose.ui.components.text.LabelMedium
import io.github.hellocuriosity.compose.ui.components.text.LabelSmall
import io.github.hellocuriosity.compose.ui.components.text.LabelTiny


@Composable
fun TextScene() {
    LazyColumn(
        modifier = Modifier.testTag("text-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            LabelLarge(
                text = "Label Large",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
        item {
            LabelMedium(
                text = "Label Medium",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
        item {
            LabelSmall(
                text = "Label Small",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
        item {
            LabelTiny(
                text = "Label Tiny",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
        item {
            ContentLarge(
                text = "Content Large",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
        item {
            ContentMedium(
                text = "Content Medium",
                modifier = Modifier.padding(8.dp)
            )
            Divider()
        }
    }
}

@Exclude
@Preview
@Composable
fun TextScenePreview() {
    TextScene()
}
