package com.hello.curiosity.compose.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hello.curiosity.compose.ui.ComposeTextTest

class LabelTinyTest : ComposeTextTest() {
    override val contentString: @Composable () -> Unit = {
        LabelTiny(
            text = text,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
        )
    }

    override val contentResource: @Composable () -> Unit = {
        LabelTiny(
            text = res,
            modifier = Modifier,
            color = Color.White,
            textAlign = null,
            style = MaterialTheme.typography.h1,
        )
    }
}
