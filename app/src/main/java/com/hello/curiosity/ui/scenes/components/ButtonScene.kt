package com.hello.curiosity.ui.scenes.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.R
import io.github.hellocuriosity.ui.Exclude
import io.github.hellocuriosity.ui.components.buttons.IconButton
import io.github.hellocuriosity.ui.components.buttons.TextButton
import io.github.hellocuriosity.ui.components.buttons.TextIconButton

private val verticalPadding = 16.dp

@Composable
@Suppress("LongMethod")
fun ButtonScene() {
    val ctx = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("button-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalPadding)
    ) {
        item {
            TextButton(
                modifier = Modifier.padding(top = verticalPadding),
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
            )
        }
        item {
            TextIconButton(
                text = R.string.btn_disabled,
                enabled = false,
                onClick = { /* no action available */ },
                contentDescription = R.string.btn_disabled,
                icon = R.drawable.ic_button,
            )
        }
        item {
            IconButton(
                onClick = {
                    Toast.makeText(ctx, "Icon Button", Toast.LENGTH_SHORT).show()
                },
                contentDescription = R.string.btn_enabled,
                icon = android.R.drawable.ic_delete
            )
        }
        item {
            IconButton(
                enabled = false,
                onClick = { /* no action available */ },
                contentDescription = R.string.btn_disabled,
                icon = android.R.drawable.ic_delete
            )
        }
    }
}

@Exclude
@Preview
@Composable
fun ButtonScenePreview() {
    ButtonScene()
}
