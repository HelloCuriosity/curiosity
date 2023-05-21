plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    // Publishing
    id("maven-publish")
    signing
}

android {
    namespace = "io.github.hellocuriosity.compose.settings"
    compileSdk = 33
    buildToolsVersion = "33.0.1"

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
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
    implementation("androidx.core:core-ktx:1.10.1")

    // Compose
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.ui:ui:1.4.3")

    // Curiosity
    implementation(project(":curiosity"))

    // It is a known bug: https://issuetracker.google.com/issues/227767363
    //
    // Google is currently working on a fix but there is already a workaround:
    // add these dependencies to every module where you use the Compose preview:
    debugApi("androidx.customview:customview:1.2.0-alpha02")
    debugApi("androidx.customview:customview-poolingcontainer:1.0.0")

    // Testing
    testImplementation("junit:junit:4.13.2")

    // Curiosity testing utils
    testImplementation(project(":test-compose-utils"))

    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
    testImplementation("org.robolectric:robolectric:4.10.3") {
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
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
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
                artifactId = "settings"

                pom {
                    name.set("Settings")
                    description.set("Settings is a collection of setting specific UI components to speed up building settings screens.")
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
