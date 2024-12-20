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
        assertEquals(R.string.button_scene_title, scene.route.title())
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
        assertEquals(R.string.color_scene_title, scene.route.title())
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
        assertEquals(R.string.components_scene_title, scene.route.title())
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
        assertEquals(R.string.input_scene_title, scene.route.title())
        assertTrue(scene.route.showTopAppBar())
        assertFalse(scene.route.showBottomNavigation())
    }

    @Test
    fun testSettings() {
        val scene = Scenes.Settings
        assertEquals(R.string.settings_scene_title, scene.title)
        assertEquals(R.drawable.ic_settings, scene.icon)
        assertEquals(R.string.settings_scene_title, scene.contentDescription)
        assertEquals("SETTINGS", scene.route)
        assertEquals(R.string.settings_scene_title, scene.route.title())
        assertFalse(scene.route.showTopAppBar())
        assertTrue(scene.route.showBottomNavigation())
    }

    @Test
    fun testText() {
        val scene = Scenes.Text
        assertEquals(R.string.text_scene_title, scene.title)
        assertEquals(R.drawable.ic_typography, scene.icon)
        assertEquals(R.string.text_scene_title, scene.contentDescription)
        assertEquals("TEXT", scene.route)
        assertEquals(R.string.text_scene_title, scene.route.title())
        assertTrue(scene.route.showTopAppBar())
        assertFalse(scene.route.showBottomNavigation())
    }

    @Test
    fun testToggle() {
        val scene = Scenes.Toggle
        assertEquals(R.string.toggle_scene_title, scene.title)
        assertEquals(R.drawable.ic_toggle, scene.icon)
        assertEquals(R.string.toggle_scene_title, scene.contentDescription)
        assertEquals("TOGGLE", scene.route)
        assertEquals(R.string.toggle_scene_title, scene.route.title())
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
        assertEquals(R.string.typography_scene_title, scene.route.title())
        assertFalse(scene.route.showTopAppBar())
        assertTrue(scene.route.showBottomNavigation())
    }
}
