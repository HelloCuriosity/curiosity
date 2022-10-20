package com.hello.curiosity.curiosity.ui.scenes.components

import com.hello.curiosity.curiosity.R
import org.junit.Assert.assertEquals
import org.junit.Test

class ComponentScenesTest {
    @Test
    fun testTextComponentScene() {
        val scene = ComponentScenes.Text
        assertEquals(R.string.text_scene_title, scene.title)
        assertEquals(R.drawable.ic_components, scene.icon)
        assertEquals("TEXT", scene.route)
    }

    @Test
    fun testButtonsComponentScene() {
        val scene = ComponentScenes.Buttons
        assertEquals(R.string.button_scene_title, scene.title)
        assertEquals(R.drawable.ic_button, scene.icon)
        assertEquals("BUTTONS", scene.route)
    }
}
