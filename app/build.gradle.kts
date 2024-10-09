import com.github.triplet.gradle.androidpublisher.ReleaseStatus
import com.github.triplet.gradle.androidpublisher.ResolutionStrategy

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.github.triplet.play") version "3.11.0"
}

android {
    namespace = "com.hello.curiosity"
    compileSdk = 34
    buildToolsVersion = "34.0.0"

    defaultConfig {
        applicationId = "com.hello.curiosity.design"
        minSdk = 23
        targetSdk = 34

        versionCode = System.getenv("GITHUB_RUN_NUMBER")?.toInt() ?: 1
        versionName = System.getenv("VERSION") ?: "local"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file("keystore/curiosity.keystore")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = "curiosity"
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("debug") {
            enableUnitTestCoverage = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    play {
        serviceAccountCredentials.set(rootProject.file("pc-api-6516078326128720260-777-76bc229fe079.json"))
        releaseStatus.set(ReleaseStatus.COMPLETED)
        resolutionStrategy.set(ResolutionStrategy.IGNORE)
        defaultToAppBundles.set(true)

        enabled.set(true)
        track.set("production")
        artifactDir.set(file("build/outputs/bundle/release"))
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    // Android
    implementation("androidx.core:core-ktx:1.13.1")

    // Compose
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.compose.material:material:1.6.5")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.5")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.5")
    implementation("androidx.compose.ui:ui:1.6.5")

    // Curiosity
    implementation(project(":curiosity"))
    implementation(project(":navigation"))
    implementation(project(":settings"))

    // Leak
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.14")

    // Testing
    testImplementation("junit:junit:4.13.2")

    // Curiosity testing utils
    testImplementation(project(":test-compose-utils"))

    // Compose
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.5")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.6.5")
    testImplementation("androidx.navigation:navigation-testing:2.7.7")

    // Robolectric
    testImplementation("org.robolectric:robolectric:4.13") {
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
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.5")
}

// Kover
dependencies {
    kover(project(":curiosity"))
    kover(project(":navigation"))
    kover(project(":settings"))
}

koverReport {
    defaults {
        mergeWith("debug")
    }
}
