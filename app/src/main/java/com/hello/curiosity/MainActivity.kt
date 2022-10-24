package com.hello.curiosity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.hello.curiosity.ui.scenes.DashboardScene
import com.hello.curiosity.ui.theme.ComposeContentView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComposeContentView {
            DashboardScene()
        }
    }
}
