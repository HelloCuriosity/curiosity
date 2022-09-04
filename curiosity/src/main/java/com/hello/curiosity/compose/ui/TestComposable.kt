package com.hello.curiosity.compose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestComposable(
    name: String
) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.primary,
    )
}

@Preview(showBackground = true)
@Composable
fun TestComposablePreview() {
    TestComposable(name = "Kyle")
}
