plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.serialization") version "1.8.20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Ktor
    implementation("io.ktor:ktor-client-content-negotiation:2.2.4")
    implementation("io.ktor:ktor-client-core:2.2.4")
    implementation("io.ktor:ktor-client-okhttp:2.2.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    // Testing
    testImplementation("junit:junit:4.13.2")

    // Model forge
    testImplementation("io.github.hellocuriosity:model-forge:1.3.0")

    // Mockk
    testImplementation("io.mockk:mockk:1.13.5")

    // Ktor
    testImplementation("io.ktor:ktor-client-mock:2.2.4")
    testImplementation("org.slf4j:slf4j-simple:2.0.7")
}
