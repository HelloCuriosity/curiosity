import kotlinx.kover.api.KoverTaskExtension

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    // Quality Gates
    id(Dependencies.Gradle.kotlinter)
    id(Dependencies.Gradle.detekt)

    // Publishing
    id("maven-publish")
}

android {
    namespace = "io.github.hellocuriosity.compose"
    compileSdk = Dependencies.Versions.compileSdk
    buildToolsVersion = Dependencies.Versions.buildToolsVersion

    defaultConfig {
        minSdk = Dependencies.Versions.minSdk
        targetSdk = Dependencies.Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = Dependencies.Versions.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.composeCompiler
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
            all {
                if (it.name == "testReleaseUnitTest") {
                    it.extensions.configure(KoverTaskExtension::class) {
                        isDisabled.set(true)
                    }
                }
            }
        }
    }
}

dependencies {
    // Android
    implementation(Dependencies.Androidx.core)

    // Compose
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.navigation)
    debugImplementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Compose.ui)

    // It is a known bug: https://issuetracker.google.com/issues/227767363
    //
    // Google is currently working on a fix but there is already a workaround:
    // add these dependencies to every module where you use the Compose preview:
    debugApi("androidx.customview:customview:1.2.0-alpha02")
    debugApi("androidx.customview:customview-poolingcontainer:1.0.0")

    // Testing
    testImplementation(Dependencies.Test.junit)

    // Curiosity testing utils
    testImplementation(project(":test-compose-utils"))

    debugImplementation(Dependencies.Test.Compose.uiTestManifest)
    testImplementation(Dependencies.Test.Compose.uiTestJunit)
    testImplementation(Dependencies.Test.robolectric) {
        exclude(module = "classworlds")
        exclude(module = "commons-logging")
        exclude(module = "httpclient")
        exclude(module = "maven-artifact")
        exclude(module = "maven-artifact-manager")
        exclude(module = "maven-error-diagnostics")
        exclude(module = "maven-model")
        exclude(module = "maven-project")
        exclude(module = "maven-settings")
        exclude(module = "plexus-container-default")
        exclude(module = "plexus-interpolation")
        exclude(module = "plexus-utils")
        exclude(module = "wagon-file")
        exclude(module = "wagon-http-lightweight")
        exclude(module = "wagon-provider-api")
        exclude(module = "auto-service")
    }

    // Android Testing
    androidTestImplementation(Dependencies.Test.Androidx.espresso)
    androidTestImplementation(Dependencies.Test.Androidx.junit)
    androidTestImplementation(Dependencies.Test.Compose.uiTestJunit)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "io.github.hellocuriosity.compose"
                artifactId = "curiosity"
                version = System.getenv("VERSION") ?: "local"

                pom {
                    name.set("Curiosity")
                    description.set("Curiosity is a simple design system just for fun.")
                    url.set("https://github.com/HelloCuriosity/curiosity")
                    licenses {
                        license {
                            name.set("MIT Licence")
                            url.set("https://github.com/HelloCuriosity/curiosity/blob/main/LICENSE")
                        }
                    }
                    scm {
                        connection.set("scm:git:https://github.com/HelloCuriosity/curiosity.git")
                        developerConnection.set("scm:git:https://github.com/HelloCuriosity/curiosity.git")
                        url.set("https://github.com/HelloCuriosity/curiosity")
                    }
                }
            }
        }
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/hopeman15/curiosity")
                credentials {
                    username = System.getenv("GPR_USER")
                    password = System.getenv("GPR_TOKEN")
                }
            }
        }
    }
}
