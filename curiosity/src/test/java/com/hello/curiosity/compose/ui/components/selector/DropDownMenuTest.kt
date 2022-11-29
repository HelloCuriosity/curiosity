package com.hello.curiosity.compose.ui.components.selector

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class DropDownMenuTest : ComposeTest() {

    private val ctx: Context = ApplicationProvider.getApplicationContext()
    private val items: List<Int> = listOf(android.R.string.copy, android.R.string.paste)
    private val contentDescriptionRes: Int = android.R.string.fingerprint_icon_content_description
    private val contentDescriptionStr: String = ctx.getString(contentDescriptionRes)

    @Test
    fun `validate drop down defaults`() {
        composeTestRule.setContent {
            DropDownMenu(
                items = items,
                onItemSelected = {},
                contentDescription = contentDescriptionRes,
            )
        }

        // validate label exists
        composeTestRule
            .onNodeWithText(text = ctx.getString(items[0]))
            .assertExists()
            .assertIsDisplayed()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(DROP_DOWN_MENU_ICN_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .assertContentDescriptionEquals(contentDescriptionStr)

        // validate container exists
        composeTestRule
            .onNodeWithTag(DROP_DOWN_MENU_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .assertHasClickAction()
            .performClick()

        // validate list items
        composeTestRule
            .onNodeWithTag(testTag = DROP_DOWN_MENU_LIST_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .onChildren()
            .assertCountEquals(2)

        // validate list item click
        composeTestRule
            .onNodeWithTag(DROP_DOWN_MENU_LIST_TEST_TAG, useUnmergedTree = true)
            .onChildAt(1)
            .performClick()
    }

    @Test
    fun `validate drop down customization`() {
        composeTestRule.setContent {
            DropDownMenu(
                items = items,
                onItemSelected = {},
                selected = 1,
                contentDescription = contentDescriptionRes,
                colors = DropDownMenuDefaults.colors(
                    backgroundColor = Color.Black,
                    boarderColor = Color.Green,
                ),
                enabled = false,
            )
        }

        // validate label exists
        composeTestRule
            .onNodeWithText(text = ctx.getString(items[1]))
            .assertExists()
            .assertIsDisplayed()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(DROP_DOWN_MENU_ICN_TEST_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .assertContentDescriptionEquals(contentDescriptionStr)

        // validate container exists
        composeTestRule
            .onNodeWithTag(DROP_DOWN_MENU_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }
}
