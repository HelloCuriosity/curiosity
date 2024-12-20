package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.Exclude
import com.hello.curiosity.R
import com.hello.curiosity.ui.theme.checkColors
import com.hello.curiosity.ui.theme.dropDownMenuColors
import com.hello.curiosity.ui.theme.toggleColors
import io.github.hellocuriosity.compose.ui.components.selector.DropDownMenu
import io.github.hellocuriosity.compose.ui.components.toggle.CheckBox
import io.github.hellocuriosity.compose.ui.components.toggle.Toggle

private val verticalPadding = 16.dp

@Composable
fun ToggleScene() {
    var isToggleChecked by remember { mutableStateOf(false) }
    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .testTag("toggle-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalPadding),
    ) {
        item {
            Toggle(
                modifier = Modifier.padding(top = verticalPadding),
                checked = isToggleChecked,
                colors = toggleColors(),
                onToggleChange = { isToggleChecked = !isToggleChecked },
            )
        }
        item {
            CheckBox(
                colors = checkColors(),
                onCheckedChange = {},
            )
        }
        item {
            DropDownMenu(
                modifier = Modifier.padding(16.dp),
                items =
                    listOf(
                        R.string.drop_down_item_one,
                        R.string.drop_down_item_two,
                    ),
                onItemSelected = {
                },
                contentDescription = R.string.content_description_drop_down,
                colors = dropDownMenuColors(),
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
