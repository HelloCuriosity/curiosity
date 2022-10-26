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

class CuriosityNavHostTest : ComposeTest() {

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            CuriosityNavHost(navController = navController)
        }

        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify start destination is ComponentScene`() {
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, Scenes.Components.route)
    }

    @Test
    fun `verify route to ButtonScene works`() {
        assertNavigateToDestination(Scenes.Buttons.route)
        composeTestRule
            .onNodeWithTag("button-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to ColorScene works`() {
        assertNavigateToDestination(Scenes.Color.route)
        composeTestRule
            .onNodeWithTag("color-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to InputScene works`() {
        assertNavigateToDestination(Scenes.Input.route)
        composeTestRule
            .onNodeWithTag("input-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to TextScene works`() {
        assertNavigateToDestination(Scenes.Text.route)
        composeTestRule
            .onNodeWithTag("text-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to TypographyScene works`() {
        assertNavigateToDestination(Scenes.Typography.route)
        composeTestRule
            .onNodeWithTag("type-scene-test-tag")
            .assertIsDisplayed()
    }

    private fun assertNavigateToDestination(scene: String) {
        navController.navigate(scene)
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, scene)
    }
}
