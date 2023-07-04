@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-parcelize")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=enable",
        )
    }

    buildFeatures {
        viewBinding = true
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
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.21")

    // Support
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.android.material:material:1.9.0")
    implementation("com.google.android.flexbox:flexbox:3.0.0")

    implementation("com.hannesdorfmann:adapterdelegates4:4.3.2")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.github.bumptech.glide:glide:4.13.2")
    kapt("com.github.bumptech.glide:compiler:4.13.2")

    // Navigation
    implementation("androidx.navigation:navigation-fragment:2.6.0")
    implementation("androidx.navigation:navigation-ui:2.6.0")
    implementation("androidx.navigation:navigation-ui:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
}
