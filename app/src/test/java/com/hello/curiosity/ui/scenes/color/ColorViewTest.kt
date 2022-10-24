package com.hello.curiosity.ui.scenes.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ColorViewTest : ComposeTest() {

    private val presentation = ColorPresentation(
        title = "cool color",
        color = Color.Blue,
    )

    @Test
    fun testColorView() {
        composeTestRule.setContent {
            ColorView(presentation = presentation)
        }

        composeTestRule
            .onNodeWithText(presentation.title)
            .assertIsDisplayed()
    }
}
