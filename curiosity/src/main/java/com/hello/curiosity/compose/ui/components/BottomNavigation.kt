package com.hello.curiosity.compose.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hello.curiosity.compose.ui.Scene

@Composable
fun BottomNavigation(
    navController: NavHostController,
    scenes: List<Scene>,
    alwaysShowLabel: Boolean = true
) = BottomNavigation {
    val currentRoute = currentRoute(navController)
    scenes.forEach { scene ->
        val title = stringResource(id = scene.title)
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = scene.icon),
                    contentDescription = title
                )
            },
            label = { Text(title) },
            selected = currentRoute == scene.route,
            alwaysShowLabel = alwaysShowLabel,
            onClick = {
                if (currentRoute != scene.route) {
                    navController.navigate(scene.route)
                }
            }
        )
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
