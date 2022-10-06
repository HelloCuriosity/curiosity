package com.hello.curiosity.curiosity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.curiosity.curiosity.ui.scenes.BottomNavScenes
import com.hello.curiosity.curiosity.ui.scenes.color.ColorScene
import com.hello.curiosity.curiosity.ui.scenes.components.ComponentScene
import com.hello.curiosity.curiosity.ui.scenes.type.TypographyScene

@Composable
fun DashboardNavGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavScenes.Components.route) {
        composable(BottomNavScenes.Components.route) {
            ComponentScene(navController = navController)
        }
        composable(BottomNavScenes.Color.route) {
            ColorScene()
        }
        composable(BottomNavScenes.Typography.route) {
            TypographyScene()
        }
        detailNavGraph(
//            navController
        )
    }
}
