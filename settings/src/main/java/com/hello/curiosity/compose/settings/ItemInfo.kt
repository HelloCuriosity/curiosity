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
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.text.ContentMedium
import com.hello.curiosity.compose.ui.components.text.LabelMedium

@Composable
fun ItemInfo(
    @StringRes title: Int,
    @StringRes content: Int,
    titleColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
) = Row(
    modifier = Modifier
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
