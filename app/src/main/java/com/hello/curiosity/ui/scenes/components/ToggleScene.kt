package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.toggle.CheckBox
import com.hello.curiosity.ui.theme.checkColors

private val verticalPadding = 16.dp

@Composable
fun ToggleScene() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("toggle-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalPadding)
    ) {
        item {
            CheckBox(
                modifier = Modifier.padding(top = verticalPadding),
                colors = checkColors(),
                onCheckedChange = {}
            )
        }
    }
}

@Preview
@Composable
fun ToggleScenePreview() {
    ToggleScene()
}
