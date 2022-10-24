package com.hello.curiosity.curiosity.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hello.curiosity.curiosity.ui.scenes.Scenes
import com.hello.curiosity.curiosity.ui.scenes.components.ButtonScene
import com.hello.curiosity.curiosity.ui.scenes.components.text.TextScene

fun NavGraphBuilder.detailNavGraph() {
    navigation(
        route = "DETAILS",
        startDestination = Scenes.Text.route
    ) {
        composable(route = Scenes.Text.route) {
            TextScene()
        }
        composable(route = Scenes.Buttons.route) {
            ButtonScene()
        }
    }
}
