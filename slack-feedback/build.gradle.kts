plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.serialization") version "1.9.10"

    // Publishing
    id("maven-publish")
    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Ktor
    implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
    implementation("io.ktor:ktor-client-core:2.3.6")
    implementation("io.ktor:ktor-client-okhttp:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // Testing
    testImplementation("junit:junit:4.13.2")

    // Model forge
    testImplementation("io.github.hellocuriosity:model-forge:1.3.0")

    // Mockk
    testImplementation("io.mockk:mockk:1.13.8")

    // Ktor
    testImplementation("io.ktor:ktor-client-mock:2.3.6")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<Sign>().configureEach {
    onlyIf { System.getenv("CI") == "true" }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
            groupId = "io.github.hellocuriosity"
            artifactId = "slack-feedback"

            pom {
                name.set("Slack Feedback")
                description.set("Slack Feedback is an easy way to collect feedback, and have it posted to a slack channel.")
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
    }

    repositories {
        maven {
            name = "MavenCentral"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")

            credentials {
                username = System.getenv("SONATYPE_USER")
                password = System.getenv("SONATYPE_PWD")
            }
        }
    }

    signing {
        val signingKey: String? = System.getenv("SIGNING_KEY")
        val signingPwd: String? = System.getenv("SIGNING_PWD")
        useInMemoryPgpKeys(signingKey, signingPwd)
        sign(publishing.publications["release"])
    }
}
