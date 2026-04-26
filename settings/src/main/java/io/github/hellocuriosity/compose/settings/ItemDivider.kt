package io.github.hellocuriosity.compose.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ItemDivider(
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 1.dp,
) = HorizontalDivider(
    modifier =
        Modifier
            .padding(horizontal = 24.dp)
            .testTag("item-divider-test-tag"),
    color = color,
    thickness = thickness,
)

@Preview
@Composable
internal fun ItemDividerPreview() {
    ItemDivider()
}
