plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")

    // Publishing
    id("maven-publish")
    signing
}

android {
    namespace = "io.github.hellocuriosity.test.compose"
    compileSdk = 35

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    // Android
    implementation("androidx.core:core-ktx:1.16.0")

    // Compose
    implementation("androidx.navigation:navigation-compose:2.9.7")
    implementation("androidx.navigation:navigation-testing:2.9.7")
    implementation("androidx.compose.ui:ui-test-junit4:1.10.3")

    // jUnit
    implementation("junit:junit:4.13.2")

    // Robolectric
    implementation("org.robolectric:robolectric:4.16.1") {
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

tasks.withType<Sign>().configureEach {
    onlyIf { System.getenv("CI") == "true" }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "io.github.hellocuriosity"
                artifactId = "test-utils"

                pom {
                    name.set("Test-Utils")
                    description.set("Test-Utils is a collection of test utilities to help test compose UIs.")
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
}
