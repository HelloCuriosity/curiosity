package io.github.hellocuriosity.compose.settings

import android.R
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
import io.github.hellocuriosity.compose.ui.components.selector.DropDownMenu
import io.github.hellocuriosity.compose.ui.components.selector.DropDownMenuColors
import io.github.hellocuriosity.compose.ui.components.selector.DropDownMenuDefaults
import io.github.hellocuriosity.compose.ui.components.text.LabelMedium

@Composable
fun ItemDropDown(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    titleColor: Color = Color.Unspecified,
    @StringRes items: List<Int> = emptyList(),
    selected: Int = 0,
    onItemSelected: (Int) -> Unit,
    @StringRes contentDescription: Int,
    enabled: Boolean = true,
    colors: DropDownMenuColors = DropDownMenuDefaults.colors(),
) = Column(
    modifier =
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .testTag(ITEM_DROP_DOWN_CONTAINER_TEST_TAG),
) {
    LabelMedium(
        text = title,
        color = titleColor,
    )
    Spacer(modifier = Modifier.size(6.dp))
    DropDownMenu(
        items = items,
        selected = selected,
        onItemSelected = onItemSelected,
        contentDescription = contentDescription,
        enabled = enabled,
        colors = colors,
    )
}

const val ITEM_DROP_DOWN_CONTAINER_TEST_TAG = "ITEM_DROP_DOWN_CONTAINER_TEST_TAG"

@Exclude
@Preview
@Composable
internal fun ItemDropDownPreview() {
    ItemDropDown(
        title = R.string.copy,
        items = listOf(R.string.copy),
        onItemSelected = { },
        contentDescription = R.string.copy,
    )
}
