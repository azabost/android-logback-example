import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    defaultConfig {
        minSdk = Config.minSdk
        compileSdk = Config.compileSdk
        targetSdk = Config.targetSdk
        versionName = "1.0"
        versionCode = 1
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(Config.jvmToolchain))
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaTargetCompatibility
        targetCompatibility = Config.javaTargetCompatibility
        isCoreLibraryDesugaringEnabled = true
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget(Config.javaTargetCompatibility.toString())
        }
    }
}
