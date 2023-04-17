package io.github.hellocuriosity.compose.settings

import android.R
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class ItemActionTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()

    private val titleRes = android.R.string.copy
    private val text = ctx.getString(titleRes)
    private val contentDescriptionRes = android.R.string.fingerprint_icon_content_description
    private val contentDescription = ctx.getString(contentDescriptionRes)

    @Test
    fun `validate item action defaults`() {
        composeTestRule.setContent {
            ItemAction(
                title = titleRes,
                icon = R.drawable.ic_delete,
                contentDescription = contentDescriptionRes,
                onClick = { },
            )
        }

        // validate item action exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-action-test-tag")
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate text exists
        composeTestRule
            .onNodeWithText(text = text, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-test-tag", useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .assertContentDescriptionEquals(contentDescription)
    }

    @Test
    fun `validate item action customization`() {
        composeTestRule.setContent {
            ItemAction(
                title = titleRes,
                icon = R.drawable.ic_delete,
                contentDescription = contentDescriptionRes,
                textColor = Color.Black,
                tint = Color.Blue,
                onClick = { },
            )
        }

        // validate item action exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-action-test-tag")
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate text exists
        composeTestRule
            .onNodeWithText(text = text, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-test-tag", useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .assertContentDescriptionEquals(contentDescription)
    }
}
