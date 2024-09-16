plugins {
    alias(libs.plugins.default.android.library)
}

android {
    namespace = "com.azabost.logging.mainscreen"
}

dependencies {
    implementation(libs.androidx.activity)
    implementation(libs.slf4j)

    testImplementation(libs.slf4j.simple)
}
