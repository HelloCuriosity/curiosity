import io.gitlab.arturbosch.detekt.Detekt
import kotlinx.kover.api.KoverProjectConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false

    id("io.gitlab.arturbosch.detekt") version "1.23.0"
    id("org.jmailen.kotlinter") version "3.15.0"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

allprojects {
    version = System.getenv("VERSION") ?: "local"

    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "org.jmailen.kotlinter")
    apply(plugin = "org.jetbrains.kotlinx.kover")

    detekt {
        buildUponDefaultConfig = false
        allRules = false
        config.setFrom("$rootDir/detekt/default-detekt-config.yml")
    }
    tasks.withType<Detekt>().configureEach {
        jvmTarget = "17"
        reports {
            xml.required.set(false)
            html.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
        }
        exclude("**/resources/**")
        exclude("**/build/**")
    }

    extensions.configure<KoverProjectConfig> {
        isDisabled.set(false)
        engine.set(kotlinx.kover.api.IntellijEngine("1.0.683"))
    }

    koverMerged {
        filters {
            classes {
                excludes += listOf(
                    "*BuildConfig",
                )
            }
            annotations {
                excludes += listOf("*Preview", "*Exclude")
            }
        }
        xmlReport {
            onCheck.set(false)
            reportFile.set(layout.buildDirectory.file("$buildDir/reports/kover/result.xml"))
        }
        htmlReport {
            onCheck.set(false)
            reportDir.set(layout.buildDirectory.dir("$buildDir/reports/kover/html-result"))
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

koverMerged {
    enable()
}
