package com.hello.curiosity.compose.ui.components

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.compose.ui.Scene
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BottomNavigationTest : ComposeTest() {
    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun testBottomNavigation() {
        val stringResource = android.R.string.untitled
        val text = context.getText(stringResource).toString()
        val scenes = listOf(
            object : Scene {
                override val title: Int = stringResource
                override val icon: Int = android.R.drawable.ic_delete
                override val route: String = "ROUTE"
            }
        )

        composeTestRule.setContent {
            val navController = rememberNavController()
            BottomNavigation(navController = navController, scenes = scenes)
        }
        composeTestRule
            .onNodeWithText(text)
            .assertIsDisplayed()
    }
}
