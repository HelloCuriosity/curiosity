package com.hello.curiosity.ui.scenes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hello.curiosity.compose.ui.Scene
import com.hello.curiosity.curiosity.R

sealed class Scenes(
    @StringRes override val title: Int,
    @DrawableRes override val icon: Int,
    @StringRes override val contentDescription: Int,
    override val route: String
) : Scene {

    object Buttons : Scenes(
        title = R.string.button_scene_title,
        icon = R.drawable.ic_button,
        contentDescription = R.string.button_scene_title,
        route = "BUTTONS"
    )

    object Color : Scenes(
        title = R.string.color_scene_title,
        icon = R.drawable.ic_color_palette,
        contentDescription = R.string.color_scene_title,
        route = "COLOR"
    )

    object Components : Scenes(
        title = R.string.components_scene_title,
        icon = R.drawable.ic_components,
        contentDescription = R.string.components_scene_title,
        route = "COMPONENTS"
    )

    object Text : Scenes(
        title = R.string.text_scene_title,
        icon = R.drawable.ic_typography,
        contentDescription = R.string.text_scene_title,
        route = "TEXT"
    )

    object Typography : Scenes(
        title = R.string.typography_scene_title,
        icon = R.drawable.ic_typography,
        contentDescription = R.string.typography_scene_title,
        route = "TYPOGRAPHY"
    )
}

fun String?.showBottomNavigation(): Boolean = when (this) {
    Scenes.Color.route -> true
    Scenes.Components.route -> true
    Scenes.Typography.route -> true
    else -> false
}

fun String?.showTopAppBar(): Boolean = when (this) {
    Scenes.Color.route -> false
    Scenes.Components.route -> false
    Scenes.Typography.route -> false
    else -> true
}
