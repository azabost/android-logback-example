plugins {
    alias(libs.plugins.default.android.library)
}

android {
    namespace = "com.azabost.logging.logback"

    defaultConfig {
        consumerProguardFiles("lib-proguard-rules.txt")
    }
}

dependencies {
    implementation(libs.slf4j)
    implementation(libs.logback.classic)
    implementation(libs.firebase.crashlytics)
}
