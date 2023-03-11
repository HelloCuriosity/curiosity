package io.github.hellocuriosity.compose.settings

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ApplicationProvider
import io.github.hellocuriosity.compose.test.ComposeTest
import io.github.hellocuriosity.compose.ui.components.selector.DropDownMenuDefaults
import org.junit.Test

class ItemDropDownTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()

    private val titleRes = android.R.string.ok
    private val title = ctx.getString(titleRes)

    private val items: List<Int> = listOf(android.R.string.copy, android.R.string.paste)
    private val contentDescriptionRes: Int = android.R.string.cut
    private val contentDescriptionStr: String = ctx.getString(contentDescriptionRes)

    @Test
    fun `validate ItemDropDown defaults`() {
        composeTestRule.setContent {
            ItemDropDown(
                title = titleRes,
                items = items,
                onItemSelected = {},
                contentDescription = contentDescriptionRes
            )
        }

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .onChildren()
            .assertCountEquals(2)

        // validate title exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .onChildAt(0)
            .assertTextEquals(title)
            .assertExists()
            .assertIsDisplayed()

        // validate label exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .onChildAt(1)
            .assertTextEquals(ctx.getString(items[0]))
            .assertContentDescriptionEquals(contentDescriptionStr)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate ItemDropDown customization`() {
        composeTestRule.setContent {
            ItemDropDown(
                title = titleRes,
                titleColor = Color.Blue,
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

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .onChildren()
            .assertCountEquals(2)

        // validate title exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .onChildAt(0)
            .assertTextEquals(title)
            .assertExists()
            .assertIsDisplayed()

        // validate label exists
        composeTestRule
            .onNodeWithTag(testTag = ITEM_DROP_DOWN_CONTAINER_TEST_TAG)
            .onChildAt(1)
            .assertTextEquals(ctx.getString(items[1]))
            .assertContentDescriptionEquals(contentDescriptionStr)
            .assertExists()
            .assertIsDisplayed()
    }
}
