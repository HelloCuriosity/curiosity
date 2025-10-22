plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")

    // Publishing
    id("maven-publish")
    signing
}

android {
    namespace = "io.github.hellocuriosity.compose"
    compileSdk = 35
    buildToolsVersion = "34.0.0"

    defaultConfig {
        minSdk = 23
        targetSdk = 34

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
        }
    }
}

dependencies {
    // Android
    implementation("androidx.core:core-ktx:1.16.0")

    // Compose
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.material:material:1.9.4")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")
    implementation("androidx.navigation:navigation-compose:2.9.5")
    debugImplementation("androidx.compose.ui:ui-tooling:1.9.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.9.4")
    implementation("androidx.compose.ui:ui:1.9.4")

    // It is a known bug: https://issuetracker.google.com/issues/227767363
    //
    // Google is currently working on a fix but there is already a workaround:
    // add these dependencies to every module where you use the Compose preview:
    debugApi("androidx.customview:customview:1.2.0")
    debugApi("androidx.customview:customview-poolingcontainer:1.1.0")

    // Testing
    testImplementation("junit:junit:4.13.2")

    // Curiosity testing utils
    testImplementation(project(":test-compose-utils"))

    debugImplementation("androidx.compose.ui:ui-test-manifest:1.9.4")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.9.4")
    testImplementation("org.robolectric:robolectric:4.16") {
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
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.9.4")
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
                artifactId = "curiosity"

                pom {
                    name.set("Curiosity")
                    description.set("Curiosity is a simple design system just for fun.")
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
