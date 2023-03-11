package io.github.hellocuriosity.ui.components.input

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComposeTest
import io.github.hellocuriosity.ui.theme.ThemeImpl
import org.junit.Test

class InputTextFieldTest : ComposeTest() {
    private val ctx: Context = ApplicationProvider.getApplicationContext()
    private val res: Int = android.R.string.copy
    private val placeholderText = ctx.getString(res)
    private val text = "text"

    @Test
    fun `validate InputTextField defaults`() {
        composeTestRule.setContent {
            InputTextField(
                value = {
                }
            )
        }

        // validate box container exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performTextInput(text)

        // validate that input is displayed
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
            .assertIsDisplayed()

        // validate counter does not exist
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_COUNTER_TEST_TAG)
            .assertDoesNotExist()
    }

    @Test
    fun `validate InputTextField customization`() {
        composeTestRule.setContent {
            InputTextField(
                modifier = Modifier.padding(4.dp),
                value = { },
                enabled = true,
                readOnly = false,
                textStyle = ThemeImpl.typography.h5,
                placeholder = res,
                placeholderStyle = ThemeImpl.typography.h5,
                keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
                keyboardActions = KeyboardActions(onDone = {}),
                singleLine = false,
                maxLines = 5,
                maxLength = 10,
                hasCounter = false,
                boarderWidth = 10.dp,
                colors = InputTextFieldDefaults.colors(
                    textColor = Color.Blue,
                    placeholderColor = Color.Black,
                    cursorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Green,
                    focusedIndicatorColor = Color.Yellow,
                    backgroundColor = Color.Magenta,
                    boarderColor = Color.Cyan,
                )
            )
        }

        // validate box container exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate placeholder text exists
        composeTestRule
            .onNodeWithText(placeholderText)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performTextInput(text)

        // validate that input is displayed
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
            .assertIsDisplayed()

        // validate counter does not exist
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_COUNTER_TEST_TAG)
            .assertDoesNotExist()
    }

    @Test
    fun `validate InputTextField counter`() {
        composeTestRule.setContent {
            InputTextField(
                value = { },
                singleLine = true,
                hasCounter = true,
                maxLength = 2
            )
        }

        // validate box container exists
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_CONTAINER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate counter does exist
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_COUNTER_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performTextInput(text)

        // validate that te is displayed
        composeTestRule
            .onNodeWithText("te")
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag(testTag = INPUT_TEXT_FIELD_VALUE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()
            .performTextInput(text)

        // validate that text is not displayed
        composeTestRule
            .onNodeWithText(text)
            .assertDoesNotExist()

        // validate counter displays 2/4
        composeTestRule
            .onNodeWithText("2/2")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test(expected = IllegalStateException::class)
    fun `validate InputTextField counter throws and exception if length isn't set`() {
        composeTestRule.setContent {
            InputTextField(
                value = { },
                hasCounter = true,
            )
        }
    }
}
