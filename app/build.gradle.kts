import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Libraries.Apps.compileSdk)
    defaultConfig {
        minSdkVersion(Libraries.Apps.minSdk)
        targetSdkVersion(Libraries.Apps.targetSdk)
        versionCode = Libraries.Apps.versionCode
        versionName = Libraries.Apps.versionName
        multiDexEnabled = false
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    dataBinding {
        isEnabled = true
    }
    compileOptions{
        sourceCompatibility=JavaVersion.VERSION_11
        targetCompatibility=JavaVersion.VERSION_11
    }
    kotlinOptions{
        jvmTarget =JavaVersion.VERSION_11.toString()
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.Libs.kotlin)
    implementation(Libraries.Libs.appcompat)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.Dagger.dagger)
    implementation(Libraries.Dagger.androidSupport)
    implementation(Libraries.Coroutines.android)
    implementation(Libraries.Coroutines.core)
    kapt(Libraries.Dagger.compiler)
    kapt(Libraries.Dagger.androidProcessor)
    implementation(Libraries.Fragment.fragment)
    implementation(Libraries.Lifecycle.extensions)
    implementation(Libraries.Glide.library)
    kapt(Libraries.Glide.compiler)
    implementation(Libraries.TestLibs.junit)
    implementation(Libraries.FireBase.messeging)
    implementation(Libraries.Timber)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.gsonConverter)
    implementation(Libraries.UI.materialComponent)

}

///home/qenawi/Main-TJW/IDE/android-studio/jre