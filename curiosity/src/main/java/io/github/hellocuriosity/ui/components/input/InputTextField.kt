package io.github.hellocuriosity.ui.components.input

import android.R
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.ui.Exclude
import io.github.hellocuriosity.ui.components.text.LabelSmall
import io.github.hellocuriosity.ui.components.text.LabelTiny

@Composable
@Suppress("LongMethod")
fun InputTextField(
    modifier: Modifier = Modifier,
    value: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = txtStyle,
    @StringRes placeholder: Int? = null,
    placeholderStyle: TextStyle = txtStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int? = null,
    hasCounter: Boolean = false,
    boarderWidth: Dp = 0.dp,
    colors: InputTextFieldColors = InputTextFieldDefaults.colors(),
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .background(
            shape = RoundedCornerShape(10.dp),
            color = colors.backgroundColor,
        )
        .border(
            border = BorderStroke(
                width = boarderWidth,
                color = colors.boarderColor,
            ),
            shape = RoundedCornerShape(10.dp),
        )
        .testTag(INPUT_TEXT_FIELD_CONTAINER_TEST_TAG)
) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(INPUT_TEXT_FIELD_VALUE_TEST_TAG),
        value = text,
        onValueChange = {
            text = if (maxLength != null) it.take(maxLength) else it
            value(text)
        },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colors.textColor,
            cursorColor = colors.cursorColor,
            unfocusedIndicatorColor = colors.unfocusedIndicatorColor,
            focusedIndicatorColor = colors.focusedIndicatorColor,
            backgroundColor = colors.backgroundColor,
        ),
        placeholder = {
            placeholder?.let { res ->
                LabelSmall(
                    text = stringResource(id = res),
                    style = placeholderStyle,
                    color = colors.placeholderColor,
                )
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
    )
    if (hasCounter) {
        LabelTiny(
            modifier = Modifier
                .padding(bottom = 4.dp, end = 8.dp)
                .align(BottomEnd)
                .testTag(INPUT_TEXT_FIELD_COUNTER_TEST_TAG),
            text = maxLength?.let { "${text.length}/$it" }
                ?: error("Counter configured without setting a length"),
            color = colors.textColor,
        )
    }
}

const val INPUT_TEXT_FIELD_CONTAINER_TEST_TAG = "INPUT_TEXT_FIELD_CONTAINER_TEST_TAG"
const val INPUT_TEXT_FIELD_VALUE_TEST_TAG = "INPUT_TEXT_FIELD_VALUE_TEST_TAG"
const val INPUT_TEXT_FIELD_COUNTER_TEST_TAG = "INPUT_TEXT_FIELD_COUNTER_TEST_TAG"

@Exclude
@Preview
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        modifier = Modifier.defaultMinSize(minHeight = 100.dp),
        placeholder = R.string.copy,
        hasCounter = true,
        maxLength = 30,
        value = { }
    )
}
