package com.hello.curiosity.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hello.curiosity.compose.ui.components.text.LabelMedium

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComponentScene(
    navController: NavHostController
) {
    val components = listOf(
        ComponentScenes.Text,
        ComponentScenes.Buttons,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.testTag("lazy-components-tag")
    ) {
        items(components) { component ->
            Card(
                modifier = Modifier
                    .padding(4.dp),
                shape = RoundedCornerShape(2.dp),
                onClick = {
                    navController.navigate(component.route)
                },
            ) {
                LabelMedium(
                    modifier = Modifier
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = component.title)
                )
            }
        }
    }
}

@Preview
@Composable
fun ComponentScenePreview() {
    ComponentScene(
        navController = rememberNavController()
    )
}
