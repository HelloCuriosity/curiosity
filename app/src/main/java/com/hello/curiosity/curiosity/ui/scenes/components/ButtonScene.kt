package com.hello.curiosity.curiosity.ui.scenes.components

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
import com.hello.curiosity.compose.ui.components.buttons.buttonColors

@Composable
fun ButtonScene() {
    val ctx = LocalContext.current

    @Suppress("MagicNumber")
    val buttonColors = buttonColors(
        backgroundColor = Color(0xFF2099F3),
        contentColor = Color.White,
        disabledBackgroundColor = Color(0xFF90CCF9),
        disabledContentColor = Color.White,
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("button-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TextButton(
                text = "Enabled Button",
                onClick = {
                    Toast.makeText(ctx, "Text Button", Toast.LENGTH_SHORT).show()
                },
                buttonColors = buttonColors,
            )
        }
        item {
            TextButton(
                text = "Disabled Button",
                enabled = false,
                onClick = { /* no action available */ },
                buttonColors = buttonColors,
            )
        }
    }
}

@Preview
@Composable
fun ButtonScenePreview() {
    ButtonScene()
}