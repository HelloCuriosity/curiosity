package com.hello.curiosity.curiosity.ui.scenes.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hello.curiosity.compose.ui.Scene
import com.hello.curiosity.curiosity.R

sealed class ComponentScenes(
    @StringRes override val title: Int,
    @DrawableRes override val icon: Int,
    override val route: String
) : Scene {

    object Text : ComponentScenes(
        title = R.string.text_scene_title,
        icon = R.drawable.ic_components,
        route = "TEXT"
    )

    object Buttons : ComponentScenes(
        title = R.string.button_scene_title,
        icon = R.drawable.ic_button,
        route = "BUTTONS"
    )
}
