import Libraries.Versions.playService

object Libraries {
    object Apps {
        const val compileSdk = 29
        const val minSdk = 21
        const val targetSdk = 29
        const val versionCode = 1
        const val versionName = "1.0.0"
    }

    object Versions {
        const val gradle = "3.6.1"
        const val kotlin = "1.3.72"
        const val appcompat = "1.0.2"
        const val playService = "4.3.3"

        /* test */
        const val junit = "4.12"
    }


    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val slidingRootNav = "com.yarolegovich:sliding-root-nav:1.1.0"
    }

    object Google {
        private const val playServiceVersion = "17.0.0"
        const val easyPermission = "pub.devrel:easypermissions:3.0.0"
        const val material = "com.google.android.material:material:1.1.0"
        const val firebaseCore = "com.google.firebase:firebase-core:17.2.2"
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1"
        const val gmsGoogleServices = "com.google.gms:google-services:${playService}"
        const val fabricPlugin = "io.fabric.tools:gradle:1.31.2"
        const val openSourceLicensesPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.1"
        const val openSourceLicensesLibrary =
            "com.google.android.gms:play-services-oss-licenses:17.0.0"
        const val playServiceBasement =
            "com.google.android.gms:play-services-basement:$playServiceVersion"
        const val playServiceBase = "com.google.android.gms:play-services-base:$playServiceVersion"
        const val playServiceGcm = "com.google.android.gms:play-services-gcm:$playServiceVersion"
        const val playServiceLocation =
            "com.google.android.gms:play-services-location:$playServiceVersion"
        const val playServiceMap = "com.google.android.gms:play-services-maps:$playServiceVersion"
    }

    object Kotlin {
        private const val version = Versions.kotlin
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val workManger = "androidx.work:work-runtime-ktx:2.3.4"
    }

    object Coroutines {
        private const val version = "1.3.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val browser = "androidx.browser:browser:1.0.0"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val palette = "androidx.palette:palette:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
        const val emoji = "androidx.emoji:emoji:1.0.0"
        const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-alpha03"
    }

    object Navigation {
        private const val version = "2.2.1"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
    }

    object Fragment {
        private const val version = "1.2.2"
        const val fragment = "androidx.fragment:fragment:$version"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
    }


    object Test {
        private const val version = "1.2.0"
        const val core = "androidx.test:core:$version"
        const val runner = "androidx.test:runner:$version"
        const val rules = "androidx.test:rules:$version"

        const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
    }

    const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"
    const val carbon = "tk.zielony:carbon:0.16.0.1"

    object Paging {
        private const val version = "2.1.1"
        const val common = "androidx.paging:paging-common-ktx:$version"
        const val runtime = "androidx.paging:paging-runtime-ktx:$version"
    }

    const val preference = "androidx.preference:preference:1.1.0"

    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
    const val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"

    object Lifecycle {
        private const val version = "2.2.0"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Room {
        private const val version = "2.2.4"
        const val common = "androidx.room:room-common:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val testing = "androidx.room:room-testing:$version"
    }

    object Work {
        private const val version = "2.3.2"
        const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
    }

    object UI {
        private const val version = "0.1.0-dev06"
        const val composeRuntime = "androidx.compose:compose-runtime:${version}"
        const val framework = "androidx.ui:ui-framework:$version"
        const val layout = "androidx.ui:ui-layout:$version"
        const val materialComponent="com.google.android.material:material:1.2.0-alpha06"
        const val material = "androidx.ui:ui-material:$version"
        const val foundation = "androidx.ui:ui-foundation:$version"
        const val animation = "androidx.ui:ui-animation:$version"
        const val tooling = "androidx.ui:ui-tooling:$version"
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.11"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Dagger {
        private const val version = "2.26"
        const val dagger = "com.google.dagger:dagger:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Retrofit {
        private const val version = "2.7.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.4.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Epoxy {
        private const val version = "3.9.0"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val paging = "com.airbnb.android:epoxy-paging:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object Coil {
        private const val version = "0.9.5"
        const val coil = "io.coil-kt:coil:$version"
    }

    object AssistedInject {
        private const val version = "0.5.2"
        const val annotationDagger2 =
            "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 =
            "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Roomigrant {
        private const val version = "0.1.7"
        const val library = "com.github.MatrixDev.Roomigrant:RoomigrantLib:$version"
        const val compiler = "com.github.MatrixDev.Roomigrant:RoomigrantCompiler:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val library = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object FireBase {
        private const val fireStoreVersion = "21.4.1"
        private const val crashLyticsVersion = "2.10.1"
        private const val cloudMesseging = "20.1.3"
        val fireStore = "com.google.firebase:firebase-firestore:$fireStoreVersion"
        val crashLytics = "com.crashlytics.sdk.android:crashlytics:$crashLyticsVersion"
        val messeging = "com.google.firebase:firebase-messaging:$cloudMesseging"
    }

    const val Timber = "com.jakewharton.timber:timber:4.7.1"

    object TestLibs {
        const val junit = "junit:junit:${Versions.junit}"
    }
}