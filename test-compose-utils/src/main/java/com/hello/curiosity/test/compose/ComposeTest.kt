package com.hello.curiosity.test.compose

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

open class ComposeTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()
}
