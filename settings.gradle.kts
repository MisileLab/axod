rootProject.name = "axod"
pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        gradlePluginPortal()
    }

    plugins {
        id("fabric-loom") version "1.0.17"
        id("org.jetbrains.kotlin.jvm") version "1.8.0"
    }

}
