import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.plugins.signing.Sign
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.vanniktech.maven.publish) apply false

    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
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
        jvmTarget = "21"
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

fun CommonExtension.configureAndroidCommon() {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig.apply {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures.apply {
        compose = true
    }
    testOptions.apply {
        unitTests.apply {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

subprojects {
    plugins.withId("com.android.application") {
        extensions.configure<ApplicationExtension>("android") {
            configureAndroidCommon()
        }
    }

    plugins.withId("com.android.library") {
        extensions.configure<LibraryExtension>("android") {
            configureAndroidCommon()
            testOptions {
                targetSdk = libs.versions.targetSdk.get().toInt()
            }
            buildTypes {
                release {
                    isMinifyEnabled = false
                }
            }
        }
    }

    plugins.withId("com.vanniktech.maven.publish") {
        extensions.configure<MavenPublishBaseExtension>("mavenPublishing") {
            // Registers the Central Portal tasks; scripts/publish.sh releases the deployment.
            publishToMavenCentral()
            signAllPublications()

            coordinates(groupId = "io.github.hellocuriosity")

            pom {
                url.set("https://github.com/HelloCuriosity/curiosity")
                licenses {
                    license {
                        name.set("MIT Licence")
                        url.set("https://github.com/HelloCuriosity/curiosity/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("hopeman15")
                        name.set("Kyle Roe")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/HelloCuriosity/curiosity.git")
                    developerConnection.set("scm:git:https://github.com/HelloCuriosity/curiosity.git")
                    url.set("https://github.com/HelloCuriosity/curiosity")
                }
            }
        }

        // Signing keys are only available on CI, so local publishing stays unsigned.
        tasks.withType<Sign>().configureEach {
            onlyIf { System.getenv("CI") == "true" }
        }
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        extensions.configure<KotlinJvmProjectExtension>("kotlin") {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    kover(project(":app"))
    kover(project(":slack-feedback"))
}

kover {
    reports {
        filters {
            excludes {
                classes("*BuildConfig")
                annotatedBy("*Preview")
            }
        }
    }
}
