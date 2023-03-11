package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class ComponentSceneTest : ComposeTest() {

    @Test
    fun testComponentScene() {
        composeTestRule.setContent {
            ComponentScene(navController = rememberNavController())
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate buttons item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(0)
            .assertExists()
            .assertIsDisplayed()

        // validate input item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(1)
            .assertExists()
            .assertIsDisplayed()

        // validate text item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(2)
            .assertExists()
            .assertIsDisplayed()

        // validate toggle item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(3)
            .assertExists()
            .assertIsDisplayed()
    }
}
