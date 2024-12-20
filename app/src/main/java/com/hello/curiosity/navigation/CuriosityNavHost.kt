package com.hello.curiosity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.curiosity.ui.scenes.Scenes
import com.hello.curiosity.ui.scenes.SettingsScene
import com.hello.curiosity.ui.scenes.color.ColorScene
import com.hello.curiosity.ui.scenes.components.ButtonScene
import com.hello.curiosity.ui.scenes.components.ComponentScene
import com.hello.curiosity.ui.scenes.components.InputScene
import com.hello.curiosity.ui.scenes.components.TextScene
import com.hello.curiosity.ui.scenes.components.ToggleScene
import com.hello.curiosity.ui.scenes.type.TypographyScene

@Composable
fun CuriosityNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Scenes.Components.route) {
        composable(route = Scenes.Buttons.route) {
            ButtonScene()
        }
        composable(Scenes.Color.route) {
            ColorScene()
        }
        composable(Scenes.Components.route) {
            ComponentScene(navController = navController)
        }
        composable(route = Scenes.Input.route) {
            InputScene()
        }
        composable(route = Scenes.Settings.route) {
            SettingsScene()
        }
        composable(route = Scenes.Text.route) {
            TextScene()
        }
        composable(route = Scenes.Toggle.route) {
            ToggleScene()
        }
        composable(Scenes.Typography.route) {
            TypographyScene()
        }
    }
}
