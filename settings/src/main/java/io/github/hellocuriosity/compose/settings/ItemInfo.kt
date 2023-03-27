package io.github.hellocuriosity.compose.settings

import android.R
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
import io.github.hellocuriosity.compose.ui.components.text.ContentMedium
import io.github.hellocuriosity.compose.ui.components.text.LabelMedium
import io.github.hellocuriosity.tools.Exclude

@Composable
fun ItemInfo(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes content: Int,
    titleColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
        .testTag("item-info-test-tag"),
    horizontalArrangement = Arrangement.SpaceBetween,
) {
    Column {
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
}

@Exclude
@Preview
@Composable
internal fun ItemInfoPreview() {
    ItemInfo(
        title = R.string.copy,
        content = R.string.copy,
    )
}
