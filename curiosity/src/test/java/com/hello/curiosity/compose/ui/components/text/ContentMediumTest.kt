package com.hello.curiosity.compose.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.hello.curiosity.compose.ui.ComposeTextTest

class ContentMediumTest : ComposeTextTest() {
    override val contentString: @Composable () -> Unit = {
        ContentMedium(
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
        ContentMedium(
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
