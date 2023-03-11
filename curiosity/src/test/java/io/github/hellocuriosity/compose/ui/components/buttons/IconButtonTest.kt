package io.github.hellocuriosity.compose.ui.components.buttons

import android.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class IconButtonTest : ComposeTest() {

    @Test
    fun `validate IconButton defaults`() {
        composeTestRule.setContent {
            IconButton(
                icon = R.drawable.ic_delete,
            ) {
                // no action
            }
        }

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-button-container-test-tag")
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-button-test-tag", useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate IconButton customization`() {
        composeTestRule.setContent {
            IconButton(
                modifier = Modifier,
                enabled = true,
                icon = R.drawable.ic_delete,
                contentDescription = R.string.copy,
                size = 55.dp,
                shape = RectangleShape,
                color = Color.Blue,
                disabledColor = Color.Black,
                tint = Color.White,
                disabledTint = Color.Yellow
            ) {
                // no action
            }
        }

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-button-container-test-tag", useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate container exists
        composeTestRule
            .onNodeWithTag(testTag = "icon-button-test-tag", useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }
}
