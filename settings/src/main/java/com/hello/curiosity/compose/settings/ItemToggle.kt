package com.hello.curiosity.compose.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.text.ContentMedium
import com.hello.curiosity.compose.ui.components.text.LabelMedium
import com.hello.curiosity.compose.ui.components.toggle.Toggle
import com.hello.curiosity.compose.ui.components.toggle.ToggleColors
import com.hello.curiosity.compose.ui.components.toggle.ToggleDefaults

@Composable
fun ItemToggle(
    @StringRes title: Int,
    @StringRes content: Int,
    titleColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    checked: Boolean = false,
    enabled: Boolean = true,
    toggleColors: ToggleColors = ToggleDefaults.colors(),
    onToggleChange: ((Boolean) -> Unit),
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .testTag("toggle-item-test-tag"),
    horizontalArrangement = Arrangement.SpaceBetween,
) {
    Column(
        modifier = Modifier.weight(1f),
    ) {
        LabelMedium(
            text = title,
            color = titleColor,
        )
        Spacer(modifier = Modifier.size(6.dp))
        ContentMedium(
            text = content,
            color = contentColor,
        )
    }
    Spacer(modifier = Modifier.size(21.dp))
    Toggle(
        colors = toggleColors,
        checked = checked,
        enabled = enabled,
        onToggleChange = onToggleChange,
    )
}

@Preview
@Composable
fun ItemTogglePreview() {
    ItemToggle(
        title = android.R.string.copy,
        content = android.R.string.fingerprint_icon_content_description,
        onToggleChange = { }
    )
}
