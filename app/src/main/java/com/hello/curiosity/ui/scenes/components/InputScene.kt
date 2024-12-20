package com.hello.curiosity.ui.scenes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hello.curiosity.Exclude
import com.hello.curiosity.R
import com.hello.curiosity.ui.theme.inputTextFieldColors
import io.github.hellocuriosity.compose.ui.components.input.InputTextField

@Composable
fun InputScene() {
    LazyColumn(
        modifier =
            Modifier
                .fillMaxWidth()
                .testTag(INPUT_SCENE_VIEW_TEST_TAG),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            InputTextField(
                modifier =
                    Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                        ),
                colors = inputTextFieldColors(),
                value = { },
            )
        }
        item {
            InputTextField(
                modifier =
                    Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                        ),
                placeholder = R.string.input_text_field_placeholder,
                colors = inputTextFieldColors(),
                value = { },
            )
        }
        item {
            InputTextField(
                modifier =
                    Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                        ),
                placeholder = R.string.input_text_field_placeholder,
                maxLength = 30,
                hasCounter = true,
                colors = inputTextFieldColors(),
                value = { },
            )
        }
    }
}

const val INPUT_SCENE_VIEW_TEST_TAG = "INPUT_SCENE_VIEW_TEST_TAG"

@Exclude
@Preview
@Composable
fun InputScenePreview() {
    InputScene()
}
