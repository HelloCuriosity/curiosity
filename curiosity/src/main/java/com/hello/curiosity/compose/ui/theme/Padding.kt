package com.hello.curiosity.compose.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Padding {
    fun multiple(multiplier: Double) = defaultPadding * multiplier.toFloat()

    val defaultPadding: Dp = 8.dp
    val quarter: Dp = multiple(0.25)
    val half: Dp = multiple(0.5)
    val oneHalf: Dp = multiple(1.5)
    val double: Dp = multiple(2.0)
    val doubleHalf: Dp = multiple(2.5)
    val triple: Dp = multiple(3.0)
    val fourfold: Dp = multiple(4.0)
    val fivefold: Dp = multiple(5.0)
    val sixfold: Dp = multiple(6.0)

    val defaultHorizontalPadding: Dp = double
}
