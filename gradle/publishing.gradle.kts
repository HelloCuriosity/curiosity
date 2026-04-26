// Shared Maven Central publishing configuration.
//
// Modules apply this script after declaring the `maven-publish` and `signing`
// plugins, and after setting:
//   extra["publishingArtifactId"]  = "..."
//   extra["publishingName"]        = "..."
//   extra["publishingDescription"] = "..."

import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.plugins.signing.Sign
import org.gradle.plugins.signing.SigningExtension

val artifactId = extra["publishingArtifactId"] as String
val publicationName = extra["publishingName"] as String
val publicationDescription = extra["publishingDescription"] as String

fun PublishingExtension.configureMavenCentral() {
    publications {
        create<MavenPublication>("release") {
            val component = if (plugins.hasPlugin("com.android.library")) "release" else "java"
            from(components[component])
            groupId = "io.github.hellocuriosity"
            this.artifactId = artifactId

            pom {
                name.set(publicationName)
                description.set(publicationDescription)
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
}

fun Project.configureSigning() {
    extensions.configure<SigningExtension>("signing") {
        useInMemoryPgpKeys(System.getenv("SIGNING_KEY"), System.getenv("SIGNING_PWD"))
        sign(extensions.getByType<PublishingExtension>().publications["release"])
    }
}

tasks.withType<Sign>().configureEach {
    onlyIf { System.getenv("CI") == "true" }
}

if (plugins.hasPlugin("com.android.library")) {
    afterEvaluate {
        extensions.configure<PublishingExtension>("publishing") { configureMavenCentral() }
        configureSigning()
    }
} else {
    extensions.configure<PublishingExtension>("publishing") { configureMavenCentral() }
    configureSigning()
}
