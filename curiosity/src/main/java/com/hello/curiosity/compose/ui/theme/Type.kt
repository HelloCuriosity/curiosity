package com.hello.curiosity.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Suppress("MagicNumber")
data class Type(
    val defaultFontFamily: FontFamily = FontFamily.Default,
    val h1: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    val subtitle2: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.5.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    val overline: TextStyle = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
) {
    fun toMaterialTypography() = Typography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        h4 = h4,
        h5 = h5,
        h6 = h6,
        subtitle1 = subtitle1,
        subtitle2 = subtitle2,
        body1 = body1,
        body2 = body2,
        button = button,
        caption = caption,
        overline = overline
    )
}
