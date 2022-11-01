package com.hello.curiosity.compose.ui.components.toggle

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.R
import com.hello.curiosity.compose.ui.Exclude

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = true,
    vectorImage: ImageVector = Icons.Filled.Check,
    @StringRes contentDescription: Int = R.string.checkbox,
    size: Dp = 32.dp,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: CheckBoxColors = CheckBoxDefaults.colors(),
    onCheckedChange: ((Boolean) -> Unit),
) {
    var isChecked by remember { mutableStateOf(checked) }
    Surface(
        modifier = modifier
            .size(size)
            .testTag("checkbox-surface-test-tag"),
        enabled = enabled,
        shape = shape,
        color = if (isChecked) colors.checkedColor else colors.uncheckedColor,
        border = if (isChecked) null else BorderStroke(1.dp, color = colors.boarderColor),
        onClick = {
            isChecked = !isChecked
            onCheckedChange(isChecked)
        }
    ) {
        if (isChecked) {
            Icon(
                modifier = Modifier
                    .testTag("checkbox-toggle-icon-test-tag"),
                imageVector = vectorImage,
                contentDescription = stringResource(id = contentDescription),
                tint = colors.checkmarkColor,
            )
        }
    }
}

@Exclude
@Preview
@Composable
fun CheckboxPreview() {
    CheckBox(
        checked = false,
        onCheckedChange = {
        }
    )
}
