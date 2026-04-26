package io.github.hellocuriosity.compose.ui.components.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

object ButtonDefaults {
    @Composable
    fun buttonColors(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = contentColorFor(containerColor),
        disabledContainerColor: Color =
            MaterialTheme.colorScheme.onSurface
                .copy(alpha = 0.12f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        disabledContentColor: Color =
            MaterialTheme.colorScheme.onSurface
                .copy(alpha = 0.38f),
    ): ButtonColors =
        ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )
}

internal fun ButtonColors.tintColor(enabled: Boolean) = if (enabled) contentColor else disabledContentColor
