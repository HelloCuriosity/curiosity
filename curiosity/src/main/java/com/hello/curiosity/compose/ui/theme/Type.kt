package com.hello.curiosity.compose.ui.theme

import androidx.compose.material3.Typography
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
    val h1: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 28.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight.Medium
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 24.sp,
        lineHeight = 34.sp,
        fontWeight = FontWeight.Medium
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Normal,
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 13.sp,
        lineHeight = 23.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 16.sp,
        lineHeight = 26.sp,
    ),
    val overline: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontSize = 12.sp,
        lineHeight = 22.sp,
    ),
) {

    fun toMaterialTypography() = Typography(
        headlineLarge = h1,
        headlineMedium = h2,
        headlineSmall = h3,
        titleLarge = h4,
        titleMedium = h5,
        titleSmall = h6,
        bodyLarge = body,
        bodySmall = body2,
        labelLarge = caption,
        labelMedium = overline,
    )
}
