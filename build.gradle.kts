import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.8.1" apply false
    id("com.android.library") version "8.8.1" apply false
    id("org.jetbrains.kotlin.android") version "2.1.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.20" apply false

    id("io.gitlab.arturbosch.detekt") version "1.23.7"
    id("org.jmailen.kotlinter") version "5.0.1"
    id("org.jetbrains.kotlinx.kover") version "0.7.6"
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
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

// Kover
dependencies {
    kover(project(":app"))
    kover(project(":slack-feedback"))
}

koverReport {
    filters {
        excludes {
            classes("*BuildConfig")
            annotatedBy("*Preview")
        }
    }

    defaults {
        xml {
            onCheck = false
            setReportFile(layout.buildDirectory.file("$buildDir/reports/kover/result.xml"))
        }
        html {
            onCheck = false
            setReportDir(layout.buildDirectory.dir("$buildDir/reports/kover/html-result"))
        }
    }
}
