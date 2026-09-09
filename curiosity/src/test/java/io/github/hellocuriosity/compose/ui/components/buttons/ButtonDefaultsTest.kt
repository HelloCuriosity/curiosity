package io.github.hellocuriosity.compose.ui.components.buttons

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.hellocuriosity.compose.test.ComposeTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ButtonDefaultsTest : ComposeTest() {
    @Test
    fun `validate ButtonDefaults textStyle() returns default values`() {
        composeTestRule.setContent {
            assertEquals(
                MaterialTheme.typography.headlineMedium.copy(fontSize = 18.sp),
                ButtonDefaults.textStyle(),
            )
        }
    }

    @Test
    fun `validate ButtonDefaults textStyle() follows the theme typography`() {
        val headlineMedium =
            TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                letterSpacing = 0.15.sp,
            )

        composeTestRule.setContent {
            MaterialTheme(typography = Typography(headlineMedium = headlineMedium)) {
                assertEquals(
                    headlineMedium.copy(fontSize = 18.sp),
                    ButtonDefaults.textStyle(),
                )
            }
        }
    }
}
