package com.hello.curiosity.curiosity.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hello.curiosity.compose.ui.TestComposable
import com.hello.curiosity.compose.ui.theme.CuriosityTheme
import com.hello.curiosity.curiosity.ui.theme.ComposeContentView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComposeContentView {
            TestComposable("Johnn")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CuriosityTheme {
        TestComposable("Android")
    }
}
