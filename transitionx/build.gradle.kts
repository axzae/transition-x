@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    namespace = Setup.Lib.namespace
    compileSdk = Setup.compileSdk

    defaultConfig {
        minSdk = Setup.minSdk
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=enable",
        )
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("com.android.support:transition:${Versions.supportLib}")
    implementation("com.android.support:interpolator:${Versions.supportLib}")
}
