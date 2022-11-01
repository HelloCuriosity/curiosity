package com.hello.curiosity.compose.settings

import android.content.Context
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class ItemSectionTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()

    private val textRes = android.R.string.copy
    private val text = ctx.getString(textRes).uppercase()

    @Test
    fun `validate item section defaults`() {
        composeTestRule.setContent {
            ItemSection(
                text = textRes
            )
        }

        composeTestRule
            .onNodeWithText(text = text, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate item section customization`() {
        composeTestRule.setContent {
            ItemSection(
                text = textRes,
                color = Color.White,
                textAlign = null,
                style = MaterialTheme.typography.h1,
            )
        }

        composeTestRule
            .onNodeWithText(text = text, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }
}
