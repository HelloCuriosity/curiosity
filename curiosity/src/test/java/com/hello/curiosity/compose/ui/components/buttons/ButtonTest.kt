package com.hello.curiosity.compose.ui.components.buttons

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.compose.ui.theme.ThemeImpl
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ButtonTest : ComposeTest() {

    private val context: Context = ApplicationProvider.getApplicationContext()
    private val res = android.R.string.ok
    private val text = context.getString(res)

    @Test
    fun `validate TextButton defaults`() {
        composeTestRule.setContent {
            TextButton(
                text = res,
                onClick = { },
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled() // validate button is enable
    }

    @Test
    fun `validate TextButton inputs`() {
        composeTestRule.setContent {
            TextButton(
                text = res,
                modifier = Modifier,
                onClick = { },
                enabled = false,
                shape = RectangleShape,
                style = ThemeImpl.typography.h1,
                buttonColors = buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Cyan,
                    disabledBackgroundColor = Color.Magenta,
                    disabledContentColor = Color.Yellow,
                ),
                textModifier = Modifier.padding(12.dp),
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsNotEnabled() // validate button is disable
    }

    @Test
    fun `validate TextIconButton defaults`() {
        composeTestRule.setContent {
            TextIconButton(
                text = res,
                contentDescription = res,
                icon = android.R.drawable.ic_delete,
                onClick = { },
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsEnabled() // validate button is enable
    }

    @Test
    fun `validate TextIconButton inputs`() {
        composeTestRule.setContent {
            TextIconButton(
                modifier = Modifier,
                text = res,
                contentDescription = res,
                icon = android.R.drawable.ic_delete,
                onClick = { },
                enabled = false,
                shape = RectangleShape,
                style = ThemeImpl.typography.h1,
                buttonColors = buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Cyan,
                    disabledBackgroundColor = Color.Magenta,
                    disabledContentColor = Color.Yellow,
                ),
                textModifier = Modifier.padding(12.dp),
            )
        }

        composeTestRule
            .onNodeWithText(text = text)
            .assertIsDisplayed()
            .performClick()
            .assertHasClickAction()
            .assertIsNotEnabled() // validate button is disable
    }
}
