package com.hello.curiosity.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.hello.curiosity.test.compose.ComposeTest
import com.hello.curiosity.ui.scenes.Scenes
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CuriosityNavHostTest : ComposeTest() {

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            CuriosityNavHost(navController = navController)
        }
    }

    @Test
    fun `verify start destination is ComponentScene`() {
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, Scenes.Components.route)
    }

    @Test
    fun `verify route to ButtonScene works`() {
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()

        assertNavigateToDestination(Scenes.Buttons.route)
    }

    @Test
    fun `verify route to ColorScene works`() {
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()

        assertNavigateToDestination(Scenes.Color.route)
    }

    @Test
    fun `verify route to TextScene works`() {
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()

        assertNavigateToDestination(Scenes.Text.route)
    }

    @Test
    fun `verify route to TypographyScene works`() {
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()

        assertNavigateToDestination(Scenes.Typography.route)
    }

    private fun assertNavigateToDestination(scene: String) {
        navController.navigate(scene)
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, scene)
    }
}
