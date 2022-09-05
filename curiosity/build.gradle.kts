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
    debugApi("androidx.customview:customview:1.2.0-alpha01")
    debugApi("androidx.customview:customview-poolingcontainer:1.0.0")

    // Testing
    testImplementation(Dependencies.Test.junit)

    debugImplementation(Dependencies.Test.Compose.uiTestManifest)
    testImplementation(Dependencies.Test.Compose.uiTestJunit)
    testImplementation(Dependencies.Test.robolectric)

    // Android Testing
    androidTestImplementation(Dependencies.Test.Androidx.espresso)
    androidTestImplementation(Dependencies.Test.Androidx.junit)
    androidTestImplementation(Dependencies.Test.Compose.uiTestJunit)
}
