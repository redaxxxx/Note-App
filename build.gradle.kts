// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}
buildscript {
    dependencies{
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.4")
    }
}