package com.hello.curiosity.curiosity.ui.scenes.components

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.hello.curiosity.compose.ui.components.buttons.TextButton

@Composable
fun ButtonScene() {
    val ctx = LocalContext.current
    LazyColumn(
        modifier = Modifier.testTag("button-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TextButton(
                text = "Text Button",
                onClick = {
                    Toast.makeText(ctx, "Text Button", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Preview
@Composable
fun ButtonScenePreview() {
    ButtonScene()
}
