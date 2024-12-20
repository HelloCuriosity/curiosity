package io.github.hellocuriosity.compose.ui.components.toggle

import android.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class CheckBoxTest : ComposeTest() {
    @Test
    fun `validate checkbox defaults`() {
        composeTestRule.setContent {
            CheckBox(onCheckedChange = {})
        }

        // validate checkbox exists
        composeTestRule
            .onNodeWithTag("checkbox-surface-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate icon dose not exists
        composeTestRule
            .onNodeWithTag(
                testTag = "checkbox-toggle-icon-test-tag",
                useUnmergedTree = true,
            ).assertDoesNotExist()

        // perform action on checkbox
        composeTestRule
            .onNodeWithTag("checkbox-surface-test-tag")
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(
                testTag = "checkbox-toggle-icon-test-tag",
                useUnmergedTree = true,
            ).assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate checkbox customization`() {
        composeTestRule.setContent {
            CheckBox(
                modifier = Modifier,
                checked = true,
                enabled = false,
                vectorImage = Icons.Filled.Home,
                contentDescription = R.string.copy,
                shape = CircleShape,
                colors =
                    CheckBoxDefaults.colors(
                        checkedColor = Color.White,
                    ),
                onCheckedChange = {},
            )
        }

        // validate checkbox exists
        composeTestRule
            .onNodeWithTag(testTag = "checkbox-surface-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate icon exists
        composeTestRule
            .onNodeWithTag(
                testTag = "checkbox-toggle-icon-test-tag",
                useUnmergedTree = true,
            ).assertExists()
            .assertIsDisplayed()
    }
}
