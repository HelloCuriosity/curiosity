package com.hello.curiosity.curiosity.ui.scenes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hello.curiosity.compose.ui.Scene
import com.hello.curiosity.curiosity.R

sealed class BottomNavScenes(
    @StringRes override val title: Int,
    @DrawableRes override val icon: Int,
    override val route: String
) : Scene {

    object Components : BottomNavScenes(
        title = R.string.components_scene_title,
        icon = R.drawable.ic_components,
        route = "COMPONENTS"
    )

    object Color : BottomNavScenes(
        title = R.string.color_scene_title,
        icon = R.drawable.ic_color_palette,
        route = "COLOR"
    )

    object Typography : BottomNavScenes(
        title = R.string.typography_scene_title,
        icon = R.drawable.ic_typography,
        route = "TYPOGRAPHY"
    )
}
