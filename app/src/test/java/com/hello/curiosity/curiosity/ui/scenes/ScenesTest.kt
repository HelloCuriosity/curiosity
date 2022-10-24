package com.hello.curiosity.curiosity.ui.scenes

import com.hello.curiosity.curiosity.R
import org.junit.Assert.assertEquals
import org.junit.Test

class ScenesTest {

    @Test
    fun testButton() {
        val scene = Scenes.Buttons
        assertEquals(R.string.button_scene_title, scene.title)
        assertEquals(R.drawable.ic_button, scene.icon)
        assertEquals(R.string.button_scene_title, scene.contentDescription)
        assertEquals("BUTTONS", scene.route)
    }

    @Test
    fun testColor() {
        val scene = Scenes.Color
        assertEquals(R.string.color_scene_title, scene.title)
        assertEquals(R.drawable.ic_color_palette, scene.icon)
        assertEquals(R.string.color_scene_title, scene.contentDescription)
        assertEquals("COLOR", scene.route)
    }

    @Test
    fun testComponents() {
        val scene = Scenes.Components
        assertEquals(R.string.components_scene_title, scene.title)
        assertEquals(R.drawable.ic_components, scene.icon)
        assertEquals(R.string.components_scene_title, scene.contentDescription)
        assertEquals("COMPONENTS", scene.route)
    }

    @Test
    fun testText() {
        val scene = Scenes.Text
        assertEquals(R.string.text_scene_title, scene.title)
        assertEquals(R.drawable.ic_typography, scene.icon)
        assertEquals(R.string.text_scene_title, scene.contentDescription)
        assertEquals("TEXT", scene.route)
    }

    @Test
    fun testTypography() {
        val scene = Scenes.Typography
        assertEquals(R.string.typography_scene_title, scene.title)
        assertEquals(R.drawable.ic_typography, scene.icon)
        assertEquals(R.string.typography_scene_title, scene.contentDescription)
        assertEquals("TYPOGRAPHY", scene.route)
    }
}
