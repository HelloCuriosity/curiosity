package io.github.hellocuriosity.compose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavHostController,
    scenes: List<Scene>,
    alwaysShowLabel: Boolean = true,
    shouldBeSelected: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    selectedContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    elevation: Dp = NavigationBarDefaults.Elevation,
) = NavigationBar(
    containerColor = backgroundColor,
    contentColor = contentColor,
    tonalElevation = elevation,
) {
    val currentRoute = currentRoute(navController)
    val itemColors =
        NavigationBarItemDefaults.colors(
            selectedIconColor = selectedContentColor,
            selectedTextColor = selectedContentColor,
            unselectedIconColor = contentColor,
            unselectedTextColor = contentColor,
        )
    scenes.forEach { scene ->
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = scene.icon),
                    contentDescription = stringResource(id = scene.contentDescription),
                )
            },
            label = { Text(stringResource(id = scene.title)) },
            colors = itemColors,
            selected = if (shouldBeSelected) currentRoute == scene.route else false,
            alwaysShowLabel = alwaysShowLabel,
            onClick = {
                if (currentRoute != scene.route) {
                    navController.navigate(scene.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            },
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
