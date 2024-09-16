pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "logging-root"
include("app")
include("logback")
include("main-screen")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
