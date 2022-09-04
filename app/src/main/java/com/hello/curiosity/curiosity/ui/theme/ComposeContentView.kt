package com.hello.curiosity.curiosity.ui.theme

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hello.curiosity.compose.ui.theme.ColorScheme
import com.hello.curiosity.compose.ui.theme.CuriosityTheme
import com.hello.curiosity.compose.ui.theme.Theme
import com.hello.curiosity.compose.ui.theme.Type

@Suppress("FunctionName")
fun ComponentActivity.ComposeContentView(content: @Composable () -> Unit) =
    setContent {
        CuriosityTheme(
//            theme = AppTheme
        ) {
            content()
        }
    }

// Used for testing
object AppTheme : Theme {
    override val typography: Type = Type(
        headlineLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 45.sp,
            lineHeight = 38.sp,
            fontWeight = FontWeight.Medium
        ),
    )
    override val colors: ColorScheme = ColorScheme(
        primary = Color.Cyan
    )
}
