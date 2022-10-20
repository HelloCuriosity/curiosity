package com.hello.curiosity.curiosity.ui.scenes.components

import androidx.compose.ui.test.assertIsDisplayed
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

        composeTestRule
            .onNodeWithTag("lazy-components-tag")
            .assertIsDisplayed()
    }
}
