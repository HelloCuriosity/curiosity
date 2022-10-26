plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    // Quality Gates
    id(Dependencies.Gradle.kotlinter)
    id(Dependencies.Gradle.detekt)
}

android {
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
    namespace = "com.hello.curiosity.test.compose"
}

dependencies {
    // Android
    implementation(Dependencies.Androidx.core)

    // Compose
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
