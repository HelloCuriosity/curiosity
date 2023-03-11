package com.hello.curiosity.ui.theme

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import io.github.hellocuriosity.ui.theme.CuriosityTheme

@Suppress("FunctionName")
fun ComponentActivity.ComposeContentView(content: @Composable () -> Unit) =
    setContent {
        CuriosityTheme(
            theme = AppTheme
        ) {
            content()
        }
    }
