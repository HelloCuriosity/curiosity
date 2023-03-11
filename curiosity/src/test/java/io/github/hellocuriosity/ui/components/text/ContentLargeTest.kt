package io.github.hellocuriosity.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import io.github.hellocuriosity.ui.ComposeTextTest

class ContentLargeTest : ComposeTextTest() {
    override val contentString: @Composable () -> Unit = {
        ContentLarge(
            text = text,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }

    override val contentResource: @Composable () -> Unit = {
        ContentLarge(
            text = res,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
