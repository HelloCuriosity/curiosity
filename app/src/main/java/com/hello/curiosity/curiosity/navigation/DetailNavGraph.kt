package com.hello.curiosity.curiosity.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hello.curiosity.curiosity.ui.scenes.TextScene
import com.hello.curiosity.curiosity.ui.scenes.components.ComponentScenes

fun NavGraphBuilder.detailNavGraph() {
    navigation(
        route = "DETAILS",
        startDestination = ComponentScenes.Text.route
    ) {
        composable(route = ComponentScenes.Text.route) {
            TextScene()
        }
    }
}
