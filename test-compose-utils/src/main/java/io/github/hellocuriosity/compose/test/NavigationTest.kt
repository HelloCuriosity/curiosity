package io.github.hellocuriosity.compose.test

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Assert.assertEquals
import org.junit.Before

abstract class NavigationTest : ComposeTest() {

    protected lateinit var navController: TestNavHostController

    protected abstract val navHost: @Composable () -> Unit

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            navHost.invoke()
        }
    }

    fun assertNavigateToDestination(scene: String) {
        navController.navigate(scene)
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, scene)
    }
}
