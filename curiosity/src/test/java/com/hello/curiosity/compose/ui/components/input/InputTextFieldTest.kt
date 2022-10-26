package com.hello.curiosity.compose.ui.components.input

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
import com.hello.curiosity.compose.ui.theme.ThemeImpl
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class InputTextFieldTest : ComposeTest() {

    private val text = "test"

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
            .onNodeWithTag("container-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag("input-text-field-test-tag")
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
            .onNodeWithTag("counter-test-tag")
            .assertDoesNotExist()
    }

    @Test
    fun `validate InputTextField customization`() {
        val placeholder = "Placeholder"
        composeTestRule.setContent {
            InputTextField(
                modifier = Modifier.padding(4.dp),
                value = { },
                enabled = true,
                readOnly = false,
                textStyle = ThemeImpl.typography.h5,
                placeholder = placeholder,
                placeholderStyle = ThemeImpl.typography.h5,
                backgroundColor = Color.White,
                colors = inputTextFieldColors(),
                keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
                keyboardActions = KeyboardActions(onDone = {}),
                singleLine = false,
                hasCounter = false,
            )
        }

        // validate box container exists
        composeTestRule
            .onNodeWithTag("container-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag("input-text-field-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate placeholder text exists
        composeTestRule
            .onNodeWithText(placeholder)
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag("input-text-field-test-tag")
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
            .onNodeWithTag("counter-test-tag")
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
            .onNodeWithTag("container-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag("input-text-field-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate counter does exist
        composeTestRule
            .onNodeWithTag("counter-test-tag")
            .assertExists()
            .assertIsDisplayed()

        // validate text field exists and input works
        composeTestRule
            .onNodeWithTag("input-text-field-test-tag")
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
            .onNodeWithTag("input-text-field-test-tag")
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
