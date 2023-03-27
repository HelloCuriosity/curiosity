package io.github.hellocuriosity.compose.ui.components.text

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ContentLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.body1,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    color = color,
    textAlign = textAlign,
    style = style,
    overflow = overflow,
    maxLines = maxLines,
)

@Composable
fun ContentLarge(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.body1,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = stringResource(id = text),
    modifier = modifier,
    color = color,
    textAlign = textAlign,
    style = style,
    overflow = overflow,
    maxLines = maxLines,
)

@Exclude
@Preview
@Composable
internal fun ContentLargePreview() {
    ContentLarge(text = "Large Content")
}
