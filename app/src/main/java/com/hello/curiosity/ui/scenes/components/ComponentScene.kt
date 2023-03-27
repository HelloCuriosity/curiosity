package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hello.curiosity.ui.scenes.Scenes
import io.github.hellocuriosity.compose.ui.components.buttons.TextIconButton
import io.github.hellocuriosity.tools.Exclude

@Composable
fun ComponentScene(
    navController: NavHostController
) {
    val components = listOf(
        Scenes.Buttons,
        Scenes.Input,
        Scenes.Text,
        Scenes.Toggle,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .testTag("component-scene-test-tag")
    ) {
        items(components) { component ->
            TextIconButton(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 4.dp),
                text = component.title,
                enabled = true,
                onClick = {
                    navController.navigate(component.route)
                },
                contentDescription = component.contentDescription,
                icon = component.icon,
            )
        }
    }
}

@Exclude
@Preview
@Composable
fun ComponentScenePreview() {
    ComponentScene(
        navController = rememberNavController()
    )
}
