package com.hello.curiosity.curiosity.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemBox(
    color: Color = Color.Transparent,
) = Box(
    modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .background(
            color = color
        )
)

@Preview
@Composable
internal fun ItemBoxPreview() {
    ItemBox()
//    ItemBox(color = Color.Cyan)
}
