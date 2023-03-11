plugins {
    `kotlin-dsl-base`
    // Using kotlin-dsl-base instead of kotlin-dsl. For rationale see:
    // * https://github.com/gradle/gradle/issues/9758#issuecomment-597780209
    // * https://github.com/gradle/gradle/pull/13073#issuecomment-830098521
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDir(file("../gradle-plugin/src/main/kotlin"))
        resources.srcDir(file("../gradle-plugin/src/main/resources"))
    }
}

java {
    // Since this is a Gradle plugin, we need to use the Java version that Gradle is using, which will differ from the
    // Java version we're using in our application.
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())
}
