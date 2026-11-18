// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.bibliotecadejuegos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.bibliotecadejuegos"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.recyclerview)
}