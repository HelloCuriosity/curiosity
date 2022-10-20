package com.hello.curiosity.curiosity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.hello.curiosity.curiosity.ui.scenes.DashboardScene
import com.hello.curiosity.curiosity.ui.theme.ComposeContentView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComposeContentView {
            DashboardScene()
        }
    }
}
