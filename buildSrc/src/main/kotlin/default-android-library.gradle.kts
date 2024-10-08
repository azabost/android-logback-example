import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    defaultConfig {
        minSdk = Config.minSdk
        compileSdk = Config.compileSdk
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(Config.jvmToolchain))
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaTargetCompatibility
        targetCompatibility = Config.javaTargetCompatibility
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget(Config.javaTargetCompatibility.toString())
        }
    }
}
