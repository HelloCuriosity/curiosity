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
import com.hello.curiosity.R
import com.hello.curiosity.compose.ui.Exclude
import com.hello.curiosity.compose.ui.components.selector.DropDownMenu
import com.hello.curiosity.compose.ui.components.toggle.CheckBox
import com.hello.curiosity.compose.ui.components.toggle.Toggle
import com.hello.curiosity.ui.theme.checkColors
import com.hello.curiosity.ui.theme.toggleColors

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
            Toggle(
                modifier = Modifier.padding(top = verticalPadding),
                colors = toggleColors(),
                onToggleChange = {}
            )
        }
        item {
            CheckBox(
                colors = checkColors(),
                onCheckedChange = {}
            )
        }
        item {
            DropDownMenu(
                modifier = Modifier.padding(16.dp),
                items = listOf(
                    R.string.toggle_scene_title,
                    R.string.settings_scene_title
                ),
                onItemSelected = {
                },
                contentDescription = R.string.content_description_drop_down
            )
        }
    }
}

@Exclude
@Preview
@Composable
fun ToggleScenePreview() {
    ToggleScene()
}
