package io.github.hellocuriosity.compose.settings

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class ItemDividerTest : ComposeTest() {

    @Test
    fun `validate item divider defaults`() {
        composeTestRule.setContent {
            ItemDivider()
        }

        composeTestRule
            .onNodeWithTag(testTag = "item-divider-test-tag")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate item divider customization`() {
        composeTestRule.setContent {
            ItemDivider(
                color = Color.Blue,
                thickness = 15.dp
            )
        }

        composeTestRule
            .onNodeWithTag(testTag = "item-divider-test-tag")
            .assertExists()
            .assertIsDisplayed()
    }
}
