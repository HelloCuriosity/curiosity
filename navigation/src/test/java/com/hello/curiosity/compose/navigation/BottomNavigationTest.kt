package com.hello.curiosity.compose.navigation

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.hello.curiosity.test.compose.ComposeTest
import org.junit.Test

class BottomNavigationTest : ComposeTest() {
    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun `validate default BottomNavigation`() {
        val stringResource = android.R.string.untitled
        val text = context.getText(stringResource).toString()
        val scenes = listOf(
            object : Scene {
                override val title: Int = stringResource
                override val icon: Int = android.R.drawable.ic_delete
                override val contentDescription: Int = stringResource
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

    @Test
    fun `validate custom BottomNavigation`() {
        val stringResource = android.R.string.untitled
        val text = context.getText(stringResource).toString()
        val scenes = listOf(
            object : Scene {
                override val title: Int = stringResource
                override val icon: Int = android.R.drawable.ic_delete
                override val contentDescription: Int = stringResource
                override val route: String = "ROUTE"
            }
        )

        composeTestRule.setContent {
            val navController = rememberNavController()
            BottomNavigation(
                navController = navController,
                scenes = scenes,
                alwaysShowLabel = false,
                shouldBeSelected = false,
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 15.dp,
            )
        }

        composeTestRule
            .onNodeWithText(text)
            .assertIsDisplayed()
    }
}
