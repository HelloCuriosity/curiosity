package com.hello.curiosity.compose.ui.components.toggle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.Exclude

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = true,
    colors: ToggleColors = ToggleDefaults.colors(),
    onToggleChange: ((Boolean) -> Unit),
) {
    var isChecked by remember { mutableStateOf(checked) }
    Surface(
        modifier = modifier
            .size(width = 63.dp, height = 36.dp)
            .testTag("toggle-surface-test-tag"),
        enabled = enabled,
        shape = RoundedCornerShape(24.dp),
        color = if (isChecked) colors.checkedColor else colors.uncheckedColor,
        border = if (isChecked) null else BorderStroke(1.dp, color = colors.boarderColor),
        onClick = {
            isChecked = !isChecked
            onToggleChange(isChecked)
        }
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentSize(
                    if (isChecked) Alignment.CenterEnd else Alignment.CenterStart
                )
                .testTag("toggle-btn-test-tag"),
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(colors.toggleColor)
            )
        }
    }
}

@Exclude
@Preview
@Composable
fun TogglePreview() {
    Toggle(
        checked = true,
        onToggleChange = { }
    )
}
