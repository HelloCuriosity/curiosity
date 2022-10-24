package com.hello.curiosity.ui.scenes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hello.curiosity.compose.ui.components.BottomNavigation
import com.hello.curiosity.compose.ui.components.currentRoute
import com.hello.curiosity.curiosity.R
import com.hello.curiosity.navigation.CuriosityNavHost

@Composable
fun DashboardScene() {
    val navController = rememberNavController()

    val scenes = listOf(
        Scenes.Components,
        Scenes.Color,
        Scenes.Typography,
    )

    Scaffold(
        modifier = Modifier.testTag("scaffold-test-tag"),
        topBar = {
            if (currentRoute(navController).showTopAppBar()) {
                TopAppBar(
                    title = { /* No title needed */ },
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                stringResource(id = R.string.content_description_back)
                            )
                        }
                    },
                    elevation = 0.dp
                )
            }
        },
        bottomBar = {
            if (currentRoute(navController).showBottomNavigation()) {
                BottomNavigation(navController = navController, scenes = scenes)
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .testTag("navigation-test-tag")
        ) {
            CuriosityNavHost(
                navController = navController
            )
        }
    }
}
