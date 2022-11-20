# Curiosity 🤓

[![Build Status](https://github.com/hopeman15/curiosity/actions/workflows/main.yml/badge.svg?event=push)](https://github.com/hopeman15/curiosity/actions)
[![codecov](https://codecov.io/gh/hopeman15/curiosity/branch/main/graph/badge.svg?token=C2EVH32Q26)](https://codecov.io/gh/hopeman15/curiosity)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/hopeman15/curiosity/blob/main/LICENSE)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](CODE_OF_CONDUCT.md)

Curiosity is a design system library _just for fun_, my rendition of building a _compose-able_ design system. You can
check out the demo app [Curiosity](https://play.google.com/store/apps/details?id=com.hello.curiosity.design) on Google
Play or build it from source here 🧑‍💻 This project is split into multiple libraries:

## Curiosity

Curiosity holds the UI components, which are split into different categories:

* Buttons
* Inputs
* Text
* Toggles

## Navigation

Navigation holds navigation components. BottomNavigation and scenes that make it easier to create uniformed scenes.

## Settings

Settings is a collection of setting specific UI components to speed up building settings screens.

## Screenshots

![overview](screenshots/dashboard_scenes.png "overview")

## Getting Started

Curiosity is currently published to github packages. You will need to generate a PAT.

Add repository to project:

```kotlin
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/hopeman15/curiosity")
        credentials {
            username = System.getenv("GPR_USER") // GitHub user
            password = System.getenv("GPR_TOKEN") // Generated PAT
        }
    }
}
```

Add dependency:

```kotlin
dependencies {
    implementation("com.hello.curiosity.compose:curiosity:0.9.2") // component library
    implementation("com.hello.curiosity.compose:navigation:0.9.2") // navigation library
    implementation("com.hello.curiosity.compose:settings:0.9.2") // settings library
    testImplementation("com.hello.curiosity.compose:test-utils:0.9.2") // testing library
}
```
