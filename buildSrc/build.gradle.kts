plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("defaultAndroidApplication") {
            id = "default.android.application"
            implementationClass = "DefaultAndroidApplicationPlugin"
        }
        register("defaultAndroidLibrary") {
            id = "default.android.library"
            implementationClass = "DefaultAndroidLibraryPlugin"
        }
        register("defaultKotlinLibrary") {
            id = "default.kotlin.library"
            implementationClass = "DefaultKotlinLibraryPlugin"
        }
    }
}