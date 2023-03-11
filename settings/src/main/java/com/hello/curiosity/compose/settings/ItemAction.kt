package com.hello.curiosity.compose.settings

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.ui.components.text.LabelMedium

@Composable
fun ItemAction(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int,
    textColor: Color = Color.Unspecified,
    tint: Color = Color.Unspecified,
    onClick: () -> Unit,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .clickable(onClick = onClick)
        .testTag("icon-action-test-tag"),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
) {
    LabelMedium(
        text = title,
        color = textColor,
    )
    Icon(
        modifier = Modifier
            .padding(start = 24.dp)
            .testTag("icon-test-tag"),
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = contentDescription),
        tint = tint,
    )
}

@Exclude
@Preview
@Composable
internal fun ItemActionPreview() {
    ItemAction(
        title = android.R.string.copy,
        icon = android.R.drawable.ic_delete,
        contentDescription = android.R.string.copy,
        tint = Color.Unspecified
    ) {
    }
}
