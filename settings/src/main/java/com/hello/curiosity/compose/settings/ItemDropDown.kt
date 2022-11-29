package com.hello.curiosity.compose.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
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
import com.hello.curiosity.compose.R
import com.hello.curiosity.compose.ui.components.selector.DropDownMenu
import com.hello.curiosity.compose.ui.components.selector.DropDownMenuColors
import com.hello.curiosity.compose.ui.components.selector.DropDownMenuDefaults
import com.hello.curiosity.compose.ui.components.text.LabelMedium

@Composable
fun ItemDropDown(
    @StringRes title: Int,
    titleColor: Color = Color.Unspecified,
    @StringRes items: List<Int> = emptyList(),
    onItemSelected: (Int) -> Unit,
    @StringRes contentDescription: Int,
    enabled: Boolean = true,
    colors: DropDownMenuColors = DropDownMenuDefaults.colors(),
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .testTag(ITEM_DROP_DOWN_VIEW_TEST_TAG),
) {
    LabelMedium(
        text = title,
        color = titleColor,
    )
    Spacer(modifier = Modifier.size(6.dp))
    DropDownMenu(
        items = items,
        onItemSelected = onItemSelected,
        contentDescription = contentDescription,
        enabled = enabled,
        colors = colors,
    )
}

const val ITEM_DROP_DOWN_VIEW_TEST_TAG = "ITEM_DROP_DOWN_VIEW_TEST_TAG"

@Exclude
@Preview
@Composable
internal fun ItemDropDownPreview() {
    ItemDropDown(
        title = android.R.string.copy,
        items = listOf(R.string.checkbox, android.R.string.copy),
        onItemSelected = { },
        contentDescription = android.R.string.copy,
    )
}
