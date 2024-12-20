package io.github.hellocuriosity.compose.settings

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import io.github.hellocuriosity.compose.test.ComposeTest
import io.github.hellocuriosity.compose.ui.components.toggle.TOGGLE_CONTAINER_TEST_TAG
import io.github.hellocuriosity.compose.ui.components.toggle.ToggleDefaults
import org.junit.Test

class ItemToggleTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()

    private val titleRes = android.R.string.copy
    private val title = ctx.getString(titleRes)
    private val contentRes = android.R.string.fingerprint_icon_content_description
    private val content = ctx.getString(contentRes)

    @Test
    fun `validate toggle item defaults`() {
        composeTestRule.setContent {
            ItemToggle(
                title = titleRes,
                content = contentRes,
                onToggleChange = {},
            )
        }

        // validate container
        composeTestRule
            .onNodeWithTag(testTag = ITEM_TOGGLE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // title exists
        composeTestRule
            .onNodeWithText(title)
            .assertExists()
            .assertIsDisplayed()

        // content exists
        composeTestRule
            .onNodeWithText(content)
            .assertExists()
            .assertIsDisplayed()

        // validate toggle
        composeTestRule
            .onNodeWithTag(testTag = TOGGLE_CONTAINER_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .performClick()
    }

    @Test
    fun `validate toggle item customization`() {
        composeTestRule.setContent {
            ItemToggle(
                title = titleRes,
                content = contentRes,
                titleColor = Color.Blue,
                contentColor = Color.Blue,
                checked = true,
                enabled = false,
                toggleColors =
                    ToggleDefaults.colors(
                        toggleColor = Color.Blue,
                    ),
                onToggleChange = {},
            )
        }

        // validate container
        composeTestRule
            .onNodeWithTag(testTag = ITEM_TOGGLE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // title exists
        composeTestRule
            .onNodeWithText(title)
            .assertExists()
            .assertIsDisplayed()

        // content exists
        composeTestRule
            .onNodeWithText(content)
            .assertExists()
            .assertIsDisplayed()

        // validate toggle
        composeTestRule
            .onNodeWithTag(testTag = TOGGLE_CONTAINER_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .performClick()
    }
}
