plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Quality Gates
    id(Dependencies.Gradle.kotlinter)
    id(Dependencies.Gradle.detekt)
}

android {
    compileSdk = Dependencies.Versions.compileSdk
    buildToolsVersion = Dependencies.Versions.buildToolsVersion

    defaultConfig {
        applicationId = "com.hello.curiosity.curiosity"
        minSdk = Dependencies.Versions.minSdk
        targetSdk = Dependencies.Versions.targetSdk

        versionCode = System.getenv("GITHUB_RUN_NUMBER")?.toInt() ?: 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
            all {
                if (it.name == "testReleaseUnitTest") {
                    it.extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
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

    // Curiosity
    implementation(project(":curiosity"))

    // Leak
    debugImplementation(Dependencies.leakCanary)

    // Testing
    testImplementation("androidx.test.ext:junit-ktx:1.1.3")
    debugImplementation(Dependencies.Test.Compose.uiTestManifest)
    testImplementation(Dependencies.Test.junit)

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
