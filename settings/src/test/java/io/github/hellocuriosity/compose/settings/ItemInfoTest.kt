package io.github.hellocuriosity.compose.settings

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class ItemInfoTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()

    private val titleRes = android.R.string.copy
    private val title = ctx.getString(titleRes)
    private val contentRes = android.R.string.fingerprint_icon_content_description
    private val content = ctx.getString(contentRes)

    @Test
    fun `validate item info defaults`() {
        composeTestRule.setContent {
            ItemInfo(
                title = titleRes,
                content = contentRes,
            )
        }

        // validate container
        composeTestRule
            .onNodeWithTag(testTag = "item-info-test-tag")
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
    }

    @Test
    fun `validate item info customization`() {
        composeTestRule.setContent {
            ItemInfo(
                modifier = Modifier.padding(15.dp),
                title = titleRes,
                content = contentRes,
                titleColor = Color.Blue,
                contentColor = Color.Blue,
            )
        }

        // validate container
        composeTestRule
            .onNodeWithTag(testTag = "item-info-test-tag")
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
    }
}
