@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = Setup.App.namespace
    compileSdk = Setup.compileSdk

    defaultConfig {
        applicationId = Setup.App.applicationId
        minSdk = Setup.minSdk
        targetSdk = Setup.targetSdk

        versionCode = Setup.versionCode
        versionName = Setup.versionName

        resValue("string", "app_name", Setup.App.name)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":transitionx"))

    implementation("androidx.core:core-ktx:1.0.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.21")

    // Support
    implementation("com.google.android.material:material:1.0.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.vectordrawable:vectordrawable:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.0.0")

    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("com.google.android.flexbox:flexbox:${Versions.flexBox}")

    // Logging
    implementation("com.jakewharton.timber:timber:${Versions.timber}")

    // Glide - Image loading
    implementation("com.github.bumptech.glide:glide:${Versions.glide}")
    kapt("com.github.bumptech.glide:compiler:${Versions.glide}")

    // Navigation
    implementation("androidx.navigation:navigation-fragment:2.0.0-rc02")
    implementation("androidx.navigation:navigation-ui:2.0.0-rc02")
    implementation("androidx.navigation:navigation-ui:2.0.0-rc02")
    implementation("androidx.navigation:navigation-ui-ktx:2.0.0-rc02")

    // Adapter Delegates
    implementation("com.hannesdorfmann:adapterdelegates3:${Versions.adapterDelegates}")

    testImplementation("junit:junit:${Versions.jUnit}")
    testImplementation("org.robolectric:robolectric:${Versions.roboElectric}")
}
