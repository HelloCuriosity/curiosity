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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hello.curiosity.compose.ui.components.text.LabelMedium
import com.hello.curiosity.curiosity.ui.scenes.BottomNavScenes
import com.hello.curiosity.curiosity.ui.scenes.TextScene
import com.hello.curiosity.curiosity.ui.scenes.color.ColorScene
import com.hello.curiosity.curiosity.ui.scenes.type.TypographyScene

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComponentScene() {
    val navController = rememberNavController()

    val components = listOf(
        ComponentScenes.Text,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
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
    ComponentScene()
}
