package com.hello.curiosity.compose.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.compose.ui.ComposeTextTest

class LabelSmallTest : ComposeTextTest() {
    override val contentString: @Composable () -> Unit = {
        LabelSmall(
            text = text,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
        )
    }

    override val contentResource: @Composable () -> Unit = {
        LabelSmall(
            text = res,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
        )
    }
}
