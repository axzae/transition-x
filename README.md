# Transition X

<p>

[![build](https://img.shields.io/github/actions/workflow/status/axzae/transition-x/pre-merge.yaml?branch=main)][actions]
[![github tag](https://img.shields.io/github/v/tag/axzae/transition-x?label=github)][releases]
[![maven central](https://img.shields.io/maven-central/v/com.axzae/transition-x)][mavencentral]

</p>

This is an **AndroidX implementation** of [arunkumar9t2's transition-x](https://github.com/arunkumar9t2/transition-x).

By using this version, you can:
- use MavenCentral
- safety turn off [Jetifier][jetifier] in your project.

## Usage

#### Gradle

```properties
# gradle.properties

android.useAndroidX=true
android.enableJetifier=false
```

```kotlin
// build.gradle.kts (app module)

dependencies {
    implementation("com.axzae:transition-x:1.2.0")
}
```

## See Also

- [Usage](https://github.com/arunkumar9t2/transition-x#introduction)

[mavencentral]: https://central.sonatype.com/artifact/com.axzae/transition-x
[actions]: https://github.com/axzae/transition-x/actions
[releases]: https://github.com/axzae/transition-x/releases
[jetifier]: https://developer.android.com/tools/jetifier
