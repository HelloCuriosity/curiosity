package com.hello.curiosity.ui.scenes.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Test

class ColorViewTest : ComposeTest() {
    private val presentation =
        ColorPresentation(
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
