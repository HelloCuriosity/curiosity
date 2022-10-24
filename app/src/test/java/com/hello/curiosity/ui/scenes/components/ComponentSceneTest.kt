package com.hello.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ComponentSceneTest : ComposeTest() {

    @Test
    fun testComponentScene() {
        composeTestRule.setContent {
            ComponentScene(navController = rememberNavController())
        }

        // validate list exists
        composeTestRule
            .onNodeWithTag("component-scene-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate text item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(0)
            .assertExists()
            .assertIsDisplayed()

        // validate buttons item exists
        composeTestRule
            .onNodeWithTag(testTag = "component-scene-test-tag")
            .onChildAt(1)
            .assertExists()
            .assertIsDisplayed()
    }
}
