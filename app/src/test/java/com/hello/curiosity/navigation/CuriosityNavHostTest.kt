package com.hello.curiosity.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.hello.curiosity.ui.scenes.Scenes
import com.hello.curiosity.ui.scenes.components.INPUT_SCENE_VIEW_TEST_TAG
import io.github.hellocuriosity.compose.test.NavigationTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CuriosityNavHostTest : NavigationTest() {
    override val navHost: @Composable () -> Unit = {
        CuriosityNavHost(navController = navController)
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
            .onNodeWithTag(testTag = INPUT_SCENE_VIEW_TEST_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to SettingsScene works`() {
        assertNavigateToDestination(Scenes.Settings.route)
        composeTestRule
            .onNodeWithTag("settings-scene-test-tag")
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
    fun `verify route to ToggleScene works`() {
        assertNavigateToDestination(Scenes.Toggle.route)
        composeTestRule
            .onNodeWithTag("toggle-scene-test-tag")
            .assertIsDisplayed()
    }

    @Test
    fun `verify route to TypographyScene works`() {
        assertNavigateToDestination(Scenes.Typography.route)
        composeTestRule
            .onNodeWithTag("type-scene-test-tag")
            .assertIsDisplayed()
    }
}
