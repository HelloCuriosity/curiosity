package io.github.hellocuriosity.compose.ui.components.toggle

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.tools.Exclude

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = true,
    colors: ToggleColors = ToggleDefaults.colors(),
    onToggleChange: ((Boolean) -> Unit),
) {
    Surface(
        modifier = modifier
            .size(width = 63.dp, height = 36.dp)
            .testTag(TOGGLE_CONTAINER_TEST_TAG),
        enabled = enabled,
        shape = RoundedCornerShape(24.dp),
        color = if (checked) colors.checkedColor else colors.uncheckedColor,
        border = if (checked) null else BorderStroke(1.dp, color = colors.boarderColor),
        onClick = { onToggleChange(!checked) }
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentSize(
                    if (checked) Alignment.CenterEnd else Alignment.CenterStart
                )
                .testTag(TOGGLE_BTN_TEST_TAG),
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

const val TOGGLE_CONTAINER_TEST_TAG = "TOGGLE_CONTAINER_TEST_TAG"
const val TOGGLE_BTN_TEST_TAG = "TOGGLE_BTN_TEST_TAG"

@Exclude
@Preview
@Composable
fun TogglePreview() {
    Toggle(
        checked = true,
        onToggleChange = { }
    )
}
