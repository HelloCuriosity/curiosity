package com.hello.curiosity.ui.scenes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hello.curiosity.R
import io.github.hellocuriosity.compose.navigation.Scene

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

    object Input : Scenes(
        title = R.string.input_scene_title,
        icon = R.drawable.ic_input,
        contentDescription = R.string.input_scene_title,
        route = "INPUT"
    )

    object Settings : Scenes(
        title = R.string.settings_scene_title,
        icon = R.drawable.ic_settings,
        contentDescription = R.string.settings_scene_title,
        route = "SETTINGS"
    )

    object Text : Scenes(
        title = R.string.text_scene_title,
        icon = R.drawable.ic_typography,
        contentDescription = R.string.text_scene_title,
        route = "TEXT"
    )

    object Toggle : Scenes(
        title = R.string.toggle_scene_title,
        icon = R.drawable.ic_toggle,
        contentDescription = R.string.toggle_scene_title,
        route = "TOGGLE"
    )

    object Typography : Scenes(
        title = R.string.typography_scene_title,
        icon = R.drawable.ic_typography,
        contentDescription = R.string.typography_scene_title,
        route = "TYPOGRAPHY"
    )
}

@StringRes
fun String?.title(): Int? = when (this) {
    Scenes.Buttons.route -> Scenes.Buttons.title
    Scenes.Color.route -> Scenes.Color.title
    Scenes.Components.route -> Scenes.Components.title
    Scenes.Input.route -> Scenes.Input.title
    Scenes.Settings.route -> Scenes.Settings.title
    Scenes.Text.route -> Scenes.Text.title
    Scenes.Toggle.route -> Scenes.Toggle.title
    Scenes.Typography.route -> Scenes.Typography.title
    else -> null
}

fun String?.showBottomNavigation(): Boolean = when (this) {
    Scenes.Color.route -> true
    Scenes.Components.route -> true
    Scenes.Typography.route -> true
    Scenes.Settings.route -> true
    else -> false
}

fun String?.showTopAppBar(): Boolean = when (this) {
    Scenes.Color.route -> false
    Scenes.Components.route -> false
    Scenes.Typography.route -> false
    Scenes.Settings.route -> false
    else -> true
}
