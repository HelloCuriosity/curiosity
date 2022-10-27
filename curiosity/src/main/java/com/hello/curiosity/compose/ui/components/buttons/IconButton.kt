package com.hello.curiosity.compose.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int = R.string.checkbox,
    size: Dp = 48.dp,
    shape: Shape = CircleShape,
    color: Color = MaterialTheme.colors.primarySurface,
    tint: Color = contentColorFor(color),
    onClick: () -> Unit,
) = Surface(
    modifier = modifier
        .size(size)
        .testTag("icon-button-container-test-tag"),
    enabled = enabled,
    shape = shape,
    color = color,
    onClick = onClick,
) {
    Icon(
        modifier = Modifier
            .testTag("icon-button-test-tag"),
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = contentDescription),
        tint = tint,
    )
}
