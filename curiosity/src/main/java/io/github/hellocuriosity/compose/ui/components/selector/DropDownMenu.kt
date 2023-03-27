package io.github.hellocuriosity.compose.ui.components.selector

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.R
import io.github.hellocuriosity.compose.ui.components.text.LabelSmall


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    @StringRes items: List<Int> = emptyList(),
    selected: Int = 0,
    onItemSelected: (Int) -> Unit,
    @StringRes contentDescription: Int,
    enabled: Boolean = true,
    colors: DropDownMenuColors = DropDownMenuDefaults.colors(),
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .testTag(DROP_DOWN_MENU_CONTAINER_TEST_TAG),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        color = colors.backgroundColor,
        border = BorderStroke(1.dp, color = colors.boarderColor),
        onClick = { expanded = !expanded }
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = 16.dp,
                horizontal = 16.dp,
            ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LabelSmall(text = items[selected])
            Icon(
                modifier = Modifier
                    .rotate(
                        if (expanded) DropDownMenuDefaults.ONE_EIGHTY_DEGREES else DropDownMenuDefaults.ZERO_DEGREES
                    )
                    .testTag(DROP_DOWN_MENU_ICN_TEST_TAG),
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id = contentDescription),
            )
        }
        DropdownMenu(
            modifier = Modifier
                .testTag(DROP_DOWN_MENU_LIST_TEST_TAG),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            items.forEachIndexed { idx, _ ->
                val item = items[idx]
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(idx)
                        expanded = !expanded
                    },
                    enabled = enabled,
                ) {
                    LabelSmall(text = item)
                }
            }
        }
    }
}

const val DROP_DOWN_MENU_CONTAINER_TEST_TAG = "DROP_DOWN_MENU_CONTAINER_TEST_TAG"
const val DROP_DOWN_MENU_ICN_TEST_TAG = "DROP_DOWN_MENU_ICN_TEST_TAG"
const val DROP_DOWN_MENU_LIST_TEST_TAG = "DROP_DOWN_MENU_LIST_TEST_TAG"

@Exclude
@Preview
@Composable
fun DropDownMenuPreview() {
    DropDownMenu(
        items = listOf(R.string.checkbox, android.R.string.copy),
        onItemSelected = { },
        contentDescription = android.R.string.copy,
    )
}
