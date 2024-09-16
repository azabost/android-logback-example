plugins {
    alias(libs.plugins.default.android.application)
    alias(libs.plugins.googlePlayServices)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.azabost.logging.app"

    defaultConfig {
        applicationId = "com.azabost.logging"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs["debug"] // Demo only. Don't use this in production.
        }
    }

    packaging {
        resources {
            excludes.add("META-INF/INDEX.LIST") // logback-core and logback-classic
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(projects.logback)
    implementation(projects.mainScreen)

    implementation(libs.androidx.activity)
}

