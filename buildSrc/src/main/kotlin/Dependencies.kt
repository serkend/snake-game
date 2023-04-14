@file:Suppress("unused")

import org.gradle.api.JavaVersion

object Config {
    val compatibleJavaVersion = JavaVersion.VERSION_1_8
    const val jvmTarget = "11"
    const val kotlinVersion = "1.7.0"
    const val gradleAndroidVersion = "7.4.0"
    const val daggerVersion = "2.44"
}

object Android {
    const val applicationId = "com.development.unique_snakegame"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33

    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentalRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Obfuscation {
    const val releaseMinifyEnabled = true
    const val debugMinifyEnabled = false
    const val releaseDebuggable = false
    const val debugDebuggable = true
}

object Plugins {
    const val application = "com.android.application"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val parcelable = "kotlin-parcelize"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val kapt = "kotlin-kapt"
    const val androidLibrary = "com.android.library"
}

object Project {
    object Dagger {
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Config.daggerVersion}"
    }
    object Android {
        const val androidGradle = "com.android.tools.build:gradle:7.4.0"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.kotlinVersion}"
    }
}

object Libs {
    object View {
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val material = "com.google.android.material:material:1.7.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.5"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

        object Test {
            const val jUnit = "junit:junit:4.13.2"
            const val mockito = "org.mockito:mockito-core:4.1.0"
            const val unit_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
        }
        object AndroidTest {
            const val jUnit = "androidx.test.ext:junit:1.1.5"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }
    object Compose {
        const val composeVersion = "1.3.2"
        const val kotlinCompiler = "1.4.2"
        private const val accompanist = "0.28.0"
        private const val coil = "2.2.2"

        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val material = "androidx.compose.material:material:1.3.1"
        const val activity = "androidx.activity:activity-compose:1.6.1"

        const val navigation = "com.google.accompanist:accompanist-navigation-animation:$accompanist"

        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.27.0"

        const val coilCompose = "io.coil-kt:coil-compose:$coil"
        const val coilSvg = "io.coil-kt:coil-svg:$coil"
        const val coilGifs = "io.coil-kt:coil-gif:$coil"


        object Test {
            const val uiJunit = "androidx.compose.ui:ui-test-junit4:$composeVersion"
            const val uiManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
        }

        object Debug {
            const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
        }
    }

    object Boom {
        private const val composeBoomVersion = "2023.01.00"

        const val composeBoom = "androidx.compose:compose-bom:$composeBoomVersion"

        /**
         * choice one
         */
        const val material3 = "androidx.compose.material3:material3"
        const val material2 = "androidx.compose.material:material"
        const val composeFoundation = "androidx.compose.foundation:foundation"
        const val composeUi = "androidx.compose.ui:ui"

        /**
         * Android Studio Preview support
         */
        const val toolingPreviw = "androidx.compose.ui:ui-tooling-preview"
        const val debugUiTooling = "androidx.compose.ui:ui-tooling"

        /**
         * ui tests
         */
        const val androidComposeTest = "androidx.compose.ui:ui-test-junit4"
        const val debugAndroidCompose = "androidx.compose.ui:ui-test-manifest"

        // Optional - Included automatically by material, only add when you need
        // the icons but not the material library (e.g. when using Material3 or a
        // custom design system based on Foundation)
        const val additionalIconsCompose = "androidx.compose.material:material-icons-core"
        // Optional - Add full set of material icons
        const val fullSetIconsCompose = "androidx.compose.material:material-icons-extended"
        // Optional - Add window size utils
        const val windowsSizeUtils = "androidx.compose.material3:material3-window-size-class"

        // Optional - Integration with activities
        const val activityCompose = "androidx.activity:activity-compose:1.6.1"
        // Optional - Integration with ViewModels
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
        // Optional - Integration with LiveData
        const val liveDataCompose = "androidx.compose.runtime:runtime-livedata"
        // Optional - Integration with RxJava
        const val rxJavaCompose = "androidx.compose.runtime:runtime-rxjava2"

    }

    object Application {
        object DependencyInjection {
            private const val koinVersion = "3.3.3"
            private const val koinCompose = "3.4.2"

            const val hilt = "com.google.dagger:hilt-android:${Config.daggerVersion}"
            const val kaptDagger = "com.google.dagger:hilt-compiler:${Config.daggerVersion}"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

            const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
            const val koinAndroidCompose = "io.insert-koin:koin-androidx-compose:$koinCompose"

            const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Config.daggerVersion}"
        }

        object Database {
            private const val roomVersion = "2.4.3"

            const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
            const val kaptRoom = "androidx.room:room-compiler:$roomVersion"
            const val roomKtx = "androidx.room:room-ktx:$roomVersion"
            const val roomPaging = "androidx.room:room-paging:$roomVersion"
        }

        object Coroutines {
            private const val version = "1.6.3"

            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        object Navigation {
            private const val nav_version =  "2.5.3"
            const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
            const val navigation_ui = "androidx.navigation:navigation-ui-ktx:$nav_version"
        }

        object Network {
            object Retrofit {
                private const val version = "2.9.0"
                const val retrofit = "com.squareup.retrofit2:retrofit:$version"
                const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$version"
            }
            object OkHttp {
                private const val version = "4.10.0"
                const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:$version"
                const val okhttp = "com.squareup.okhttp3:okhttp:$version"
            }

        }
    }
}