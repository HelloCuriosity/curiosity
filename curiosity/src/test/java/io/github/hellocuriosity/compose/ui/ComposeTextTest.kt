package io.github.hellocuriosity.compose.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

abstract class ComposeTextTest : ComposeTest() {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @StringRes
    val res: Int = android.R.string.copy
    val text = context.getString(res)

    abstract val contentString: @Composable () -> Unit
    abstract val contentResource: @Composable () -> Unit

    @Test
    fun `validate text with string`() {
        composeTestRule.setContent {
            contentString.invoke()
        }
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `validate text with resource`() {
        composeTestRule.setContent {
            contentResource.invoke()
        }

        composeTestRule
            .onNodeWithText(text)
            .assertExists()
            .assertIsDisplayed()
    }
}
