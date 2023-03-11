import java.util.Locale

object Dependencies {
    object Versions {
        const val agp = "7.4.2"
        const val compose = "1.3.3"
        const val composeCompiler = "1.4.3"
        const val jvmTarget = "11"
        const val kotlin = "1.8.10"
        const val navigation = "2.5.3"
        const val playPublisher = "3.8.1"

        // App
        const val compileSdk = 33
        const val buildToolsVersion = "31.0.0"
        const val minSdk = 23
        const val targetSdk = 33

        // Quality Gates
        const val detekt = "1.22.0"
        const val gradleVersions = "0.46.0"
        const val kotlinter = "3.13.0"
        const val kover = "0.6.1"
    }

    object Androidx {
        const val core = "androidx.core:core-ktx:1.9.0"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:1.6.1"
        const val material = "androidx.compose.material:material:1.3.1"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    }

    object Gradle {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val kotlinter = "org.jmailen.kotlinter"
        const val kover = "org.jetbrains.kotlinx.kover"
        const val versions = "com.github.ben-manes.versions"
        const val playPublisher = "com.github.triplet.play"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.10"

    object Test {
        object Androidx {
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
            const val junit = "androidx.test.ext:junit:1.1.5"
        }

        object Compose {
            const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
            const val navigationTest = "androidx.navigation:navigation-testing:${Versions.navigation}"
        }

        const val junit = "junit:junit:4.13.2"
        const val robolectric = "org.robolectric:robolectric:4.9.2"
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = setOf("RELEASE", "FINAL", "GA").any { version.toUpperCase(Locale.ROOT).contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
