plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.vanniktech.maven.publish)
}

android {
    namespace = "io.github.hellocuriosity.test.compose"
}

// This module hosts test utilities; it has no tests of its own.
tasks.withType<Test>().configureEach { failOnNoDiscoveredTests = false }

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.testing)
    implementation(libs.androidx.compose.ui.test.junit4)

    implementation(libs.junit)
}

extra["robolectricConfiguration"] = "implementation"
apply(from = "$rootDir/gradle/robolectric.gradle.kts")

mavenPublishing {
    coordinates(artifactId = "test-utils")

    pom {
        name.set("Test-Utils")
        description.set("Test-Utils is a collection of test utilities to help test compose UIs.")
    }
}
