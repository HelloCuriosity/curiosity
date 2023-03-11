package io.github.hellocuriosity.navigation

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class BottomNavigationTest : ComposeTest() {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private lateinit var navController: TestNavHostController

    private val scene1Resource = android.R.string.untitled
    private val scene2Resource = android.R.string.cancel
    private val scene1Text = context.getText(scene1Resource).toString()
    private val scene2Text = context.getText(scene2Resource).toString()
    private val scenes = listOf(
        object : Scene {
            override val title: Int = scene1Resource
            override val icon: Int = android.R.drawable.ic_delete
            override val contentDescription: Int = scene1Resource
            override val route: String = "ROUTE_1"
        },
        object : Scene {
            override val title: Int = scene2Resource
            override val icon: Int = android.R.drawable.ic_delete
            override val contentDescription: Int = scene2Resource
            override val route: String = "ROUTE_2"
        }
    )

    @Test
    fun `validate default BottomNavigation`() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            NavHost(navController, startDestination = "ROUTE_1") {
                composable(route = "ROUTE_1") {
                    Text(text = "Rout 1")
                }
                composable(route = "ROUTE_2") {
                    Text(text = "Rout 2")
                }
            }
            BottomNavigation(navController = navController, scenes = scenes)
        }

        // validate nav item 1
        composeTestRule
            .onNodeWithText(scene1Text)
            .assertExists()
            .assertIsDisplayed()

        // validate nav item 2
        composeTestRule
            .onNodeWithText(scene2Text)
            .assertExists()
            .assertIsDisplayed()

        // validate starting point is scene 1
        val route1 = navController.currentBackStackEntry?.destination?.route
        assertEquals(route1, scenes[0].route)

        // click on nav item 2
        composeTestRule
            .onNodeWithText(scene2Text)
            .performClick()

        // validate navigation to scene 2
        val route2 = navController.currentBackStackEntry?.destination?.route
        assertEquals(route2, scenes[1].route)

        // click on nav item 2
        composeTestRule
            .onNodeWithText(scene2Text)
            .performClick()

        // validate no action taken when clicking on a nav item that is already visible
        val route3 = navController.currentBackStackEntry?.destination?.route
        assertEquals(route3, scenes[1].route)
    }

    @Test
    fun `validate custom BottomNavigation`() {
        val scenes = listOf(
            object : Scene {
                override val title: Int = scene1Resource
                override val icon: Int = android.R.drawable.ic_delete
                override val contentDescription: Int = scene1Resource
                override val route: String = "ROUTE"
            }
        )

        composeTestRule.setContent {
            val navController = rememberNavController()
            BottomNavigation(
                navController = navController,
                scenes = scenes,
                alwaysShowLabel = false,
                shouldBeSelected = false,
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 15.dp,
            )
        }

        composeTestRule
            .onNodeWithText(scene1Text)
            .assertExists()
            .assertIsDisplayed()
    }
}
