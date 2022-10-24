package com.hello.curiosity.ui.scenes.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.buttons.TextButton
import com.hello.curiosity.compose.ui.components.buttons.TextIconButton
import com.hello.curiosity.curiosity.R

@Composable
fun ButtonScene() {
    val ctx = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("button-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TextButton(
                text = R.string.btn_enabled,
                onClick = {
                    Toast.makeText(ctx, "Text Button", Toast.LENGTH_SHORT).show()
                },
            )
        }
        item {
            TextButton(
                text = R.string.btn_enabled,
                enabled = false,
                onClick = { /* no action available */ },
            )
        }
        item {
            TextIconButton(
                text = R.string.btn_enabled,
                enabled = true,
                onClick = {
                    Toast.makeText(ctx, "Text Icon Button", Toast.LENGTH_SHORT).show()
                },
                contentDescription = R.string.btn_enabled,
                icon = R.drawable.ic_button,
                tint = Color.White,
            )
        }
        item {
            TextIconButton(
                text = R.string.btn_disabled,
                enabled = false,
                onClick = { /* no action available */ },
                contentDescription = R.string.btn_disabled,
                icon = R.drawable.ic_button,
                tint = Color.White,
            )
        }
    }
}

@Preview
@Composable
fun ButtonScenePreview() {
    ButtonScene()
}
