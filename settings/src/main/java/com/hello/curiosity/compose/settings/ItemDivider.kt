package com.hello.curiosity.compose.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ItemDivider(
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 1.dp,
) = Divider(
    modifier = Modifier
        .padding(horizontal = 24.dp)
        .testTag("item-divider-test-tag"),
    color = color,
    thickness = thickness,
)

// private const val DividerAlpha = 0.12f
