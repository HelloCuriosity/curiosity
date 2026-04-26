plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    `maven-publish`
    signing
}

android {
    namespace = "io.github.hellocuriosity.compose"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Workaround for https://issuetracker.google.com/issues/227767363
    debugApi(libs.androidx.customview)
    debugApi(libs.androidx.customview.poolingcontainer)

    testImplementation(libs.junit)
    testImplementation(project(":test-compose-utils"))
    testImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
}

extra["robolectricConfiguration"] = "testImplementation"
apply(from = "$rootDir/gradle/robolectric.gradle.kts")

extra["publishingArtifactId"] = "curiosity"
extra["publishingName"] = "Curiosity"
extra["publishingDescription"] = "Curiosity is a simple design system just for fun."
apply(from = "$rootDir/gradle/publishing.gradle.kts")
