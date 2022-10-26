package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.compose.ui.components.input.InputTextField
import com.hello.curiosity.ui.theme.inputColors

@Composable
fun InputScene() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("input-scene-test-tag"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            InputTextField(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                    ),
                placeholder = "",
                backgroundColor = Color.White,
                colors = inputColors(),
                value = { }
            )
        }
        item {
            InputTextField(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                    ),
                placeholder = "With Placeholder",
                placeholderColor = Color.Gray,
                backgroundColor = Color.White,
                colors = inputColors(),
                value = { }
            )
        }
        item {
            InputTextField(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                    ),
                placeholder = "With Counter",
                placeholderColor = Color.Gray,
                maxLength = 30,
                hasCounter = true,
                backgroundColor = Color.White,
                colors = inputColors(),
                value = { }
            )
        }
    }
}

@Preview
@Composable
fun InputScenePreview() {
    InputScene()
}
