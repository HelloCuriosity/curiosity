package com.hello.curiosity.ui.scenes

import com.hello.curiosity.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ScenesTest {

    @Test
    fun testButton() {
        val scene = Scenes.Buttons
        assertEquals(R.string.button_scene_title, scene.title)
        assertEquals(R.drawable.ic_button, scene.icon)
        assertEquals(R.string.button_scene_title, scene.contentDescription)
        assertEquals("BUTTONS", scene.route)
        assertTrue(scene.route.showTopAppBar())
        assertFalse(scene.route.showBottomNavigation())
    }

    @Test
    fun testColor() {
        val scene = Scenes.Color
        assertEquals(R.string.color_scene_title, scene.title)
        assertEquals(R.drawable.ic_color_palette, scene.icon)
        assertEquals(R.string.color_scene_title, scene.contentDescription)
        assertEquals("COLOR", scene.route)
        assertFalse(scene.route.showTopAppBar())
        assertTrue(scene.route.showBottomNavigation())
    }

    @Test
    fun testComponents() {
        val scene = Scenes.Components
        assertEquals(R.string.components_scene_title, scene.title)
        assertEquals(R.drawable.ic_components, scene.icon)
        assertEquals(R.string.components_scene_title, scene.contentDescription)
        assertEquals("COMPONENTS", scene.route)
        assertFalse(scene.route.showTopAppBar())
        assertTrue(scene.route.showBottomNavigation())
    }

    @Test
    fun testInput() {
        val scene = Scenes.Input
        assertEquals(R.string.input_scene_title, scene.title)
        assertEquals(R.drawable.ic_input, scene.icon)
        assertEquals(R.string.input_scene_title, scene.contentDescription)
        assertEquals("INPUT", scene.route)
        assertTrue(scene.route.showTopAppBar())
        assertFalse(scene.route.showBottomNavigation())
    }

    @Test
    fun testText() {
        val scene = Scenes.Text
        assertEquals(R.string.text_scene_title, scene.title)
        assertEquals(R.drawable.ic_typography, scene.icon)
        assertEquals(R.string.text_scene_title, scene.contentDescription)
        assertEquals("TEXT", scene.route)
        assertTrue(scene.route.showTopAppBar())
        assertFalse(scene.route.showBottomNavigation())
    }

    @Test
    fun testTypography() {
        val scene = Scenes.Typography
        assertEquals(R.string.typography_scene_title, scene.title)
        assertEquals(R.drawable.ic_typography, scene.icon)
        assertEquals(R.string.typography_scene_title, scene.contentDescription)
        assertEquals("TYPOGRAPHY", scene.route)
        assertFalse(scene.route.showTopAppBar())
        assertTrue(scene.route.showBottomNavigation())
    }
}