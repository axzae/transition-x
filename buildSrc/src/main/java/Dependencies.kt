object Plugins {
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExt = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navigationPlugin = "androidx.navigation.safeargs"
    const val androidMaven = "com.github.dcendents.android-maven"
    const val jfrogBintay = "com.jfrog.bintray"
    const val dokka = "org.jetbrains.dokka-android"
}
//
// object BuildDetails {
//    const val compileSdk = 28
//    const val minSdk = 19
//    const val targetSdk = 28
//    const val versionCode = 1
//    const val versionName = "1.0.1"
//    const val libraryPackageName = "in.arunkumarsampath.transitionx"
//    val librarySample = "$libraryPackageName.sample"
// }

object Versions {
    const val supportLib = "28.0.0"
    const val constraintLayout = "1.1.3"
    const val kotlin = "1.2.71"
    const val androidKtx = "1.9.0"
    const val archNavigation = "1.0.0-beta02"
    const val flexBox = "3.0.0"
    const val timber = "4.7.1"
    const val glide = "4.13.2"
    const val adapterDelegates = "3.0.1"

    // Tests
    const val jUnit = "4.12"
    const val testRunner = "1.0.2"
    const val espresso = "3.0.2"
    const val roboElectric = "3.8"
}

object Dependencies {

//    const val androidGradle = "3.4.2"
//    const val supportLibrary = "28.0.0"
//    const val flexbox = "1.0.0"
//    const val constraintLayout = "1.1.3"
//    const val glide = "4.8.0"
//    const val kotlin = "1.3.21"
//    const val junit = "4.12"
//    const val roboelectric = "4.2"
//    const val timber = "4.6.0"
//    const val rx = "2.1.13"
//    const val rxKotlin = "2.2.0"
//    const val rxAndroid = "2.0.1"
//    const val rxBinding = "2.1.1"
//    const val butterKnife = "8.8.1"
//    const val ktx = "0.3"
//    const val navigation = "1.0.0-beta02"
//    const val adapterDelegates = "3.0.1"

    // Kotlin
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // Support
    val appCompat = "com.android.support:appcompat-v7:${Versions.supportLib}"
    val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    val supportDesign = "com.android.support:design:${Versions.supportLib}"
    val recyclerView = "com.android.support:recyclerview-v7:${Versions.supportLib}"
    val transition = "com.android.support:transition:${Versions.supportLib}"
    val interpolator = "com.android.support:interpolator:${Versions.supportLib}"

    // Flexbox layout
    val flexBox = "com.google.android:flexbox:${Versions.flexBox}"

    // Timber
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // KTX
    val androidKtx = "androidx.core:core-ktx:${Versions.androidKtx}"

    // Jetpack navigation
    val navigationFragment = "android.arch.navigation:navigation-fragment:${Versions.archNavigation}"
    val navigationFragmentKtx = "android.arch.navigation:navigation-fragment-ktx:${Versions.archNavigation}"
    val navigationUi = "android.arch.navigation:navigation-ui:${Versions.archNavigation}"
    val navigationUiKtx = "android.arch.navigation:navigation-ui-ktx:${Versions.archNavigation}"
    val navigationPlugin = "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.archNavigation}"

    // Adapter Delegates
    val adapterDelegates = "com.hannesdorfmann:adapterdelegates3:${Versions.adapterDelegates}"

    // Image Loading
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideAnnotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Test
    val jUnit = "junit:junit:${Versions.jUnit}"
    val androidJUnitRunner = "android.support.test.runner.AndroidJUnitRunner"
    val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val robotElectric = "org.robolectric:robolectric:${Versions.roboElectric}"

    val androidMaven = "com.github.dcendents:android-maven-gradle-plugin:1.5"
    val jfrogBintay = "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4"
    val dokka = "org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.17"
}
