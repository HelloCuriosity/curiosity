# Curiosity 🤓

[![Build Status](https://github.com/HelloCuriosity/curiosity/actions/workflows/main.yml/badge.svg?event=push)](https://github.com/HelloCuriosity/curiosity/actions)
[![codecov](https://codecov.io/gh/HelloCuriosity/curiosity/branch/main/graph/badge.svg?token=C2EVH32Q26)](https://codecov.io/gh/HelloCuriosity/curiosity)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](LICENSE)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](CODE_OF_CONDUCT.md)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.hellocuriosity/curiosity?color=blue)](https://central.sonatype.com/search?q=io.github.hellocuriosity)

Curiosity is a design system library _just for fun_, my rendition of building a _compose-able_ design system. You can
check out the demo app [Curiosity](https://play.google.com/store/apps/details?id=com.hello.curiosity.design) on Google
Play or build it from source here 🧑‍💻 This project is split into multiple libraries:

### Curiosity

Curiosity holds the UI components, which are split into different categories:

* Buttons
* Inputs
* Text
* Toggles

### Navigation

Navigation holds navigation components. BottomNavigation and scenes that make it easier to create uniformed scenes.

### Settings

Settings is a collection of setting specific UI components to speed up building settings screens.

### Slack Feedback

Slack feedback is a tool that makes it easy to use send feedback to a specified slack channel.

### Test-Utils

Test-Utils is a collection of test utilities to help test compose UIs.

## Screenshots

![overview](screenshots/dashboard_scenes.png "overview")

## Getting Started

Add dependency:

```kotlin
dependencies {
    implementation("io.github.hellocuriosity:curiosity:0.12.0") // component library
    implementation("io.github.hellocuriosity:navigation:0.12.0") // navigation library
    implementation("io.github.hellocuriosity:settings:0.12.0") // settings library
    implementation("io.github.hellocuriosity:slack-feedback:0.12.0") // slack feedback library
    testImplementation("io.github.hellocuriosity:test-utils:0.12.0") // testing library
}
```

## Apps Using Curiosity

In addition to [Curiosity](https://play.google.com/store/apps/details?id=com.hello.curiosity.design) you can find a list
of apps using the curiosity design system.

| App                                                                                         | Description                                                 | Uses |
|---------------------------------------------------------------------------------------------|-------------------------------------------------------------|------|
| [Signore Sorriso](https://play.google.com/store/apps/details?id=com.hello.curiosity.jokes)  | Signore Sorriso is full of fun jokes for the whole family. | &bull; Curiosity<br/>&bull; Navigation<br/>&bull; Settings<br/>&bull; Test-Utils                                            |
