package com.hello.curiosity.ui.theme

import androidx.compose.ui.graphics.Color
import com.hello.curiosity.ui.theme.AppTheme.lightCyan
import com.hello.curiosity.ui.theme.AppTheme.metallicSeaweed
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AppThemeTest : ComposeTest() {

    @Test
    fun `validate check box colors in light mode`() {
        composeTestRule.setContent {
            val colors = checkColors(isDarkMode = false)
            assertEquals(metallicSeaweed, colors.checkedColor)
            assertEquals(lightCyan, colors.uncheckedColor)
            assertEquals(lightCyan, colors.checkmarkColor)
            assertEquals(metallicSeaweed, colors.boarderColor)
        }
    }

    @Test
    fun `validate check box colors in dark mode`() {
        composeTestRule.setContent {
            val colors = checkColors(isDarkMode = true)
            assertEquals(lightCyan, colors.checkedColor)
            assertEquals(metallicSeaweed, colors.uncheckedColor)
            assertEquals(metallicSeaweed, colors.checkmarkColor)
            assertEquals(lightCyan, colors.boarderColor)
        }
    }

    @Test
    fun `validate drop down menu colors in light mode`() {
        composeTestRule.setContent {
            val colors = dropDownMenuColors(isDarkMode = false)
            assertEquals(lightCyan, colors.backgroundColor)
            assertEquals(metallicSeaweed, colors.boarderColor)
        }
    }

    @Test
    fun `validate drop down menu colors in dark mode`() {
        composeTestRule.setContent {
            val colors = dropDownMenuColors(isDarkMode = true)
            assertEquals(metallicSeaweed, colors.backgroundColor)
            assertEquals(lightCyan, colors.boarderColor)
        }
    }

    @Test
    fun `validate input text field colors`() {
        composeTestRule.setContent {
            val colors = inputTextFieldColors()
            assertEquals(Color.Black, colors.textColor)
            assertEquals(Color.Black, colors.cursorColor)
            assertEquals(Color.White, colors.backgroundColor)
        }
    }

    @Test
    fun `validate toggle colors in light mode`() {
        composeTestRule.setContent {
            val colors = toggleColors(isDarkMode = false)
            assertEquals(metallicSeaweed, colors.checkedColor)
            assertEquals(lightCyan, colors.uncheckedColor)
            assertEquals(metallicSeaweed, colors.boarderColor)
        }
    }

    @Test
    fun `validate toggle colors in dark mode`() {
        composeTestRule.setContent {
            val colors = toggleColors(isDarkMode = true)
            assertEquals(lightCyan, colors.checkedColor)
            assertEquals(metallicSeaweed, colors.uncheckedColor)
            assertEquals(lightCyan, colors.boarderColor)
        }
    }
}
