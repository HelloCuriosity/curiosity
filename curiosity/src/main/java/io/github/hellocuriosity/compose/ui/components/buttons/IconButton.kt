package io.github.hellocuriosity.compose.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.R

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int = R.string.checkbox,
    size: Dp = 50.dp,
    shape: Shape = CircleShape,
    color: Color = MaterialTheme.colorScheme.primary,
    disabledColor: Color =
        MaterialTheme.colorScheme.onSurface
            .copy(alpha = 0.12f)
            .compositeOver(MaterialTheme.colorScheme.surface),
    tint: Color = contentColorFor(color),
    disabledTint: Color =
        MaterialTheme.colorScheme.onSurface
            .copy(alpha = 0.38f),
    onClick: () -> Unit,
) = Surface(
    modifier =
        modifier
            .size(size)
            .testTag("icon-button-container-test-tag"),
    enabled = enabled,
    shape = shape,
    color = if (enabled) color else disabledColor,
    onClick = onClick,
) {
    Icon(
        modifier =
            Modifier
                .padding(8.dp)
                .testTag("icon-button-test-tag"),
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = contentDescription),
        tint = if (enabled) tint else disabledTint,
    )
}
