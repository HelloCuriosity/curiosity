package io.github.hellocuriosity.compose.settings

import android.R
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hellocuriosity.compose.ui.components.text.LabelSmall

@Composable
fun ItemSection(
    @StringRes text: Int,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.h6,
) = LabelSmall(
    modifier =
        Modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp),
    text = stringResource(id = text).uppercase(),
    color = color,
    textAlign = textAlign,
    style = style,
)

@Exclude
@Preview
@Composable
internal fun ItemSectionPreview() {
    ItemSection(text = R.string.copy)
}
