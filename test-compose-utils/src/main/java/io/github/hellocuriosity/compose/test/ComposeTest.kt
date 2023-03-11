package io.github.hellocuriosity.compose.test

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
open class ComposeTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()
}
