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

    implementation("androidx.core:core-ktx:${Versions.androidKtx}")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

    // Support
    implementation("com.android.support:design:${Versions.supportLib}")
    implementation("com.android.support:cardview-v7:${Versions.supportLib}")
    implementation("com.android.support:support-vector-drawable:${Versions.supportLib}")
    implementation("com.android.support:recyclerview-v7:${Versions.supportLib}")

    implementation("com.android.support.constraint:constraint-layout:${Versions.constraintLayout}")

    implementation("com.google.android.flexbox:flexbox:${Versions.flexBox}")

    // Logging
    implementation("com.jakewharton.timber:timber:${Versions.timber}")

    // Glide - Image loading
    implementation("com.github.bumptech.glide:glide:${Versions.glide}")
    kapt("com.github.bumptech.glide:compiler:${Versions.glide}")

    // Navigation
    implementation("android.arch.navigation:navigation-fragment:${Versions.archNavigation}")
    implementation("android.arch.navigation:navigation-ui:${Versions.archNavigation}")
    implementation("android.arch.navigation:navigation-ui:${Versions.archNavigation}")
    implementation("android.arch.navigation:navigation-ui-ktx:${Versions.archNavigation}")

    // Adapter Delegates
    implementation("com.hannesdorfmann:adapterdelegates3:${Versions.adapterDelegates}")

    testImplementation("junit:junit:${Versions.jUnit}")
    testImplementation("org.robolectric:robolectric:${Versions.roboElectric}")
}
