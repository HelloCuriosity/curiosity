package com.hello.curiosity.test.compose

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.core.app.ActivityScenario
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

open class ComponentActivityTest<A : ComponentActivity> {

    protected lateinit var activityScenario: ActivityScenario<A>

    @get:Rule
    val rule: AndroidComposeTestRule<EmptyTestRule, A> = AndroidComposeTestRule(EmptyTestRule()) {
        var activity: A? = null
        activityScenario.onActivity {
            activity = it
        }
        checkNotNull(activity) { "Activity didn't launch" }
    }

    class EmptyTestRule : TestRule {
        override fun apply(base: Statement, description: Description) = base
    }
}
