package com.hello.curiosity.compose.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavHostController,
    scenes: List<Scene>,
    alwaysShowLabel: Boolean = true,
    shouldBeSelected: Boolean = true,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation,
) = BottomNavigation(
    backgroundColor = backgroundColor,
    contentColor = contentColor,
    elevation = elevation,
) {
    val currentRoute = currentRoute(navController)
    scenes.forEach { scene ->
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = scene.icon),
                    contentDescription = stringResource(id = scene.contentDescription)
                )
            },
            label = { Text(stringResource(id = scene.title)) },
            selected = if (shouldBeSelected) currentRoute == scene.route else false,
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
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
