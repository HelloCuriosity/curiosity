package com.hello.curiosity.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.hello.curiosity.R
import com.hello.curiosity.ui.theme.AppTheme.lightCyan
import com.hello.curiosity.ui.theme.AppTheme.metallicSeaweed
import io.github.hellocuriosity.ui.components.input.InputTextFieldDefaults
import io.github.hellocuriosity.ui.components.selector.DropDownMenuDefaults
import io.github.hellocuriosity.ui.components.toggle.CheckBoxDefaults
import io.github.hellocuriosity.ui.components.toggle.ToggleDefaults
import io.github.hellocuriosity.ui.theme.ColorScheme
import io.github.hellocuriosity.ui.theme.Theme
import io.github.hellocuriosity.ui.theme.Type

object AppTheme : Theme {
    override val typography: Type = Type(
        defaultFontFamily = FontFamily(
            Font(R.font.rubik_light, FontWeight.Light),
            Font(R.font.rubik_regular, FontWeight.Normal),
            Font(R.font.rubik_medium, FontWeight.Medium),
            Font(R.font.rubik_semi_bold, FontWeight.SemiBold),
            Font(R.font.rubik_extra_bold, FontWeight.ExtraBold),
        )
    )

    val lightCyan = Color(0xFFD0F4EA)
    val metallicSeaweed = Color(0xFF087E8B)
    val onyx = Color(0xFF3C3C3C)
    val redCrayola = Color(0xFFFF5A5F)

    override val colors: ColorScheme = ColorScheme(
        primary = metallicSeaweed,
        surface = metallicSeaweed,
        onSurface = lightCyan,
        primaryVariant = redCrayola,
        background = lightCyan,

        primaryDark = lightCyan,
        surfaceDark = lightCyan,
        onSurfaceDark = metallicSeaweed,
        primaryVariantDark = redCrayola,
        backgroundDark = onyx,
    )
}

@Composable
fun checkColors(isDarkMode: Boolean = isSystemInDarkTheme()) = CheckBoxDefaults.colors(
    checkedColor = if (isDarkMode) lightCyan else metallicSeaweed,
    uncheckedColor = if (isDarkMode) metallicSeaweed else lightCyan,
    checkmarkColor = if (isDarkMode) metallicSeaweed else lightCyan,
    boarderColor = if (isDarkMode) lightCyan else metallicSeaweed,
)

@Composable
fun dropDownMenuColors(isDarkMode: Boolean = isSystemInDarkTheme()) = DropDownMenuDefaults.colors(
    backgroundColor = if (isDarkMode) metallicSeaweed else lightCyan,
    boarderColor = if (isDarkMode) lightCyan else metallicSeaweed,
)

@Composable
fun inputTextFieldColors() = InputTextFieldDefaults.colors(
    textColor = Color.Black,
    cursorColor = Color.Black,
    backgroundColor = Color.White
)

@Composable
fun toggleColors(isDarkMode: Boolean = isSystemInDarkTheme()) = ToggleDefaults.colors(
    checkedColor = if (isDarkMode) lightCyan else metallicSeaweed,
    uncheckedColor = if (isDarkMode) metallicSeaweed else lightCyan,
    boarderColor = if (isDarkMode) lightCyan else metallicSeaweed,
)
