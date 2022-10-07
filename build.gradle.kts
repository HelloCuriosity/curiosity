import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import io.gitlab.arturbosch.detekt.Detekt
import kotlinx.kover.api.KoverProjectConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version Dependencies.Versions.agp apply false
    id("com.android.library") version Dependencies.Versions.agp apply false
    id("org.jetbrains.kotlin.android") version Dependencies.Versions.kotlin apply false

    id(Dependencies.Gradle.detekt) version Dependencies.Versions.detekt
    id(Dependencies.Gradle.kotlinter) version Dependencies.Versions.kotlinter
    id(Dependencies.Gradle.kover) version Dependencies.Versions.kover
    id(Dependencies.Gradle.versions) version Dependencies.Versions.gradleVersions
}

allprojects {
    apply(plugin = Dependencies.Gradle.detekt)
    apply(plugin = Dependencies.Gradle.kotlinter)
    apply(plugin = Dependencies.Gradle.kover)

    detekt {
        buildUponDefaultConfig = false
        allRules = false
        config = files("$rootDir/detekt/default-detekt-config.yml")
    }
    tasks.withType<Detekt>().configureEach {
        jvmTarget = Dependencies.Versions.jvmTarget
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

    kotlinter {
        disabledRules = arrayOf(
            "trailing-comma",
            "trailing-comma-on-call-site",
            "trailing-comma-on-declaration-site"
        )
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = Dependencies.Versions.jvmTarget
    }
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
    outputFormatter = "html"
}

koverMerged {
    enable()
}
