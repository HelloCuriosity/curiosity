package com.hello.curiosity.compose.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.ui.components.toggle.Toggle
import io.github.hellocuriosity.compose.ui.components.toggle.ToggleColors
import io.github.hellocuriosity.compose.ui.components.toggle.ToggleDefaults

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
        .testTag(ITEM_TOGGLE_TEST_TAG),
    horizontalArrangement = Arrangement.SpaceBetween,
) {
    ItemInfo(
        modifier = Modifier.weight(1f),
        title = title,
        content = content,
        titleColor = titleColor,
        contentColor = contentColor,
    )
    Toggle(
        modifier = Modifier.padding(24.dp),
        colors = toggleColors,
        checked = checked,
        enabled = enabled,
        onToggleChange = onToggleChange,
    )
}

const val ITEM_TOGGLE_TEST_TAG = "ITEM_TOGGLE_TEST_TAG"

@Exclude
@Preview
@Composable
internal fun ItemTogglePreview() {
    ItemToggle(
        title = android.R.string.copy,
        content = android.R.string.fingerprint_icon_content_description,
        onToggleChange = { }
    )
}
