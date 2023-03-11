package io.github.hellocuriosity.ui.components.toggle

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class ToggleTest : ComposeTest() {
    @Test
    fun `validate toggle defaults`() {
        composeTestRule.setContent {
            Toggle(onToggleChange = {})
        }

        // validate toggle exists
        composeTestRule
            .onNodeWithTag(TOGGLE_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(TOGGLE_BTN_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate toggle customization`() {
        composeTestRule.setContent {
            Toggle(
                modifier = Modifier,
                checked = true,
                enabled = false,
                colors = ToggleDefaults.colors(
                    toggleColor = Color.Blue,
                ),
                onToggleChange = {}
            )
        }

        // validate toggle exists
        composeTestRule
            .onNodeWithTag(TOGGLE_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(TOGGLE_BTN_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }
}
