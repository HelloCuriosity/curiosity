// Adds Robolectric with the project's standard exclusion list.
//
// Modules apply this script after setting:
//   extra["robolectricConfiguration"] = "testImplementation" // or "implementation"

import org.gradle.api.artifacts.VersionCatalogsExtension

val configuration = extra["robolectricConfiguration"] as String
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

val excludedModules = listOf(
    "classworlds",
    "commons-logging",
    "httpclient",
    "maven-artifact",
    "maven-artifact-manager",
    "maven-error-diagnostics",
    "maven-model",
    "maven-project",
    "maven-settings",
    "plexus-container-default",
    "plexus-interpolation",
    "plexus-utils",
    "wagon-file",
    "wagon-http-lightweight",
    "wagon-provider-api",
    "auto-service",
)

dependencies {
    configuration(libs.findLibrary("robolectric").get()) {
        excludedModules.forEach { exclude(module = it) }
    }
}
