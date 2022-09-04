package com.hello.curiosity.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class Type(
    val defaultFontFamily: FontFamily = FontFamily.Default,
    val toolBarStyle: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Medium
    ),
    val headlineLarge: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 28.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight.Medium
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 24.sp,
        lineHeight = 34.sp,
        fontWeight = FontWeight.Medium
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val titleLarge: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Normal,
    ),
    val titleMedium: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val titleSmall: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 13.sp,
        lineHeight = 23.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
    ),
    val labelLarge: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 16.sp,
        lineHeight = 26.sp,
    ),
    val labelMedium: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 12.sp,
        lineHeight = 22.sp,
    ),
) {
    fun toMaterialTypography() = Typography(
        h1 = headlineLarge,
        h2 = headlineMedium,
        h3 = headlineSmall,
        h4 = titleLarge,
        h5 = titleMedium,
        h6 = titleSmall,
        body1 = bodyLarge,
        body2 = bodySmall,
        caption = labelLarge,
        overline = labelMedium,
    )
}
