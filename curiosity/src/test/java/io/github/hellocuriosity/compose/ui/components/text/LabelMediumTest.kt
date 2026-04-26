package io.github.hellocuriosity.compose.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import io.github.hellocuriosity.compose.ui.ComposeTextTest

class LabelMediumTest : ComposeTextTest() {
    override val contentString: @Composable () -> Unit = {
        LabelMedium(
            text = text,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.displayLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }

    override val contentResource: @Composable () -> Unit = {
        LabelMedium(
            text = res,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.displayLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
