package com.hello.curiosity.compose.ui.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hello.curiosity.compose.ui.components.text.LabelSmall
import com.hello.curiosity.compose.ui.components.text.LabelTiny
import com.hello.curiosity.compose.ui.theme.ThemeImpl

private val txtStyle = ThemeImpl.typography.h5.copy(fontSize = 18.sp)

@Composable
fun inputTextFieldColors(
    textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),
    cursorColor: Color = MaterialTheme.colors.primary,
): TextFieldColors =
    TextFieldDefaults.textFieldColors(
        textColor = textColor,
        cursorColor = cursorColor,
        unfocusedIndicatorColor = Color.Unspecified,
        focusedIndicatorColor = Color.Unspecified,
        backgroundColor = Color.Unspecified,
    )

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = txtStyle,
    placeholder: String = "",
    placeholderColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
    placeholderStyle: TextStyle = txtStyle,
    backgroundColor: Color = Color.Unspecified,
    colors: TextFieldColors = inputTextFieldColors(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int? = null,
    hasCounter: Boolean = false,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .background(
            shape = RoundedCornerShape(10.dp),
            color = backgroundColor,
        )
        .testTag("container-test-tag")
) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .testTag("input-text-field-test-tag"),
        value = text,
        onValueChange = {
            text = if (maxLength != null) it.take(maxLength) else it
            value(text)
        },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        colors = colors,
        placeholder = {
            LabelSmall(
                text = placeholder,
                style = placeholderStyle,
                color = placeholderColor,
            )
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
                .testTag("counter-test-tag"),
            text = maxLength?.let { "${text.length}/$it" }
                ?: error("Counter configured without setting a length"),
            color = colors.textColor(enabled = true).value
        )
    }
}

@Preview
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        modifier = Modifier.defaultMinSize(minHeight = 100.dp),
        placeholder = "Placeholder",
        hasCounter = true,
        maxLength = 30,
        value = { }
    )
}
