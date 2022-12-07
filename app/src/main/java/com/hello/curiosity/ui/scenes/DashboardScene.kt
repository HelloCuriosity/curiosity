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
import com.hello.curiosity.R
import com.hello.curiosity.compose.navigation.BottomNavigation
import com.hello.curiosity.compose.navigation.currentRoute
import com.hello.curiosity.compose.ui.components.text.LabelMedium
import com.hello.curiosity.navigation.CuriosityNavHost

@Composable
fun DashboardScene() {
    val navController = rememberNavController()

    val scenes = listOf(
        Scenes.Components,
        Scenes.Color,
        Scenes.Typography,
        Scenes.Settings,
    )

    Scaffold(
        modifier = Modifier.testTag(DASHBOARD_SCENE_VIEW_TEST_TAG),
        topBar = {
            TopAppBar(
                modifier = Modifier.testTag(DASHBOARD_SCENE_TOP_APP_BAR_TEST_TAG),
                title = {
                    currentRoute(navController).title()?.let { res ->
                        LabelMedium(
                            text = stringResource(id = res),
                        )
                    }
                },
                navigationIcon = {
                    if (currentRoute(navController).showTopAppBar()) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = stringResource(id = R.string.content_description_back),
                            )
                        }
                    }
                },
                elevation = 0.dp
            )
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
                .testTag(DASHBOARD_SCENE_NAVIGATION_TEST_TAG)
        ) {
            CuriosityNavHost(
                navController = navController
            )
        }
    }
}

const val DASHBOARD_SCENE_NAVIGATION_TEST_TAG = "DASHBOARD_SCENE_NAVIGATION_TEST_TAG"
const val DASHBOARD_SCENE_TOP_APP_BAR_TEST_TAG = "DASHBOARD_SCENE_TOP_APP_BAR_TEST_TAG"
const val DASHBOARD_SCENE_VIEW_TEST_TAG = "DASHBOARD_SCENE_VIEW_TEST_TAG"
