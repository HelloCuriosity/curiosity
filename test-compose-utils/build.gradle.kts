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
    namespace = "io.github.hellocuriosity.test.compose"
    compileSdk = Dependencies.Versions.compileSdk
    buildToolsVersion = Dependencies.Versions.buildToolsVersion

    defaultConfig {
        minSdk = Dependencies.Versions.minSdk
        targetSdk = Dependencies.Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    // Android
    implementation(Dependencies.Androidx.core)

    // Compose
    implementation(Dependencies.Compose.navigation)
    implementation(Dependencies.Test.Compose.navigationTest)
    implementation(Dependencies.Test.Compose.uiTestJunit)

    // jUnit
    implementation(Dependencies.Test.junit)

    // Robolectric
    implementation(Dependencies.Test.robolectric) {
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
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "io.github.hellocuriosity.compose"
                artifactId = "test-utils"
                version = System.getenv("VERSION") ?: "local"

                pom {
                    name.set("Curiosity")
                    description.set("Curiosity is a simple design system just for fun.")
                    url.set("https://github.com/hopeman15/curiosity")
                    licenses {
                        license {
                            name.set("MIT Licence")
                            url.set("https://github.com/hopeman15/curiosity/blob/main/LICENSE")
                        }
                    }
                    scm {
                        connection.set("scm:git:https://github.com/hopeman15/curiosity.git")
                        developerConnection.set("scm:git:https://github.com/hopeman15/curiosity.git")
                        url.set("https://github.com/hopeman15/curiosity")
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
