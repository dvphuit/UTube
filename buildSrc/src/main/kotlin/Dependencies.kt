const val kotlinVersion = "1.4.32"
const val hiltVersion = "2.35"
const val composeVersion = "1.0.0-beta06"

object BuildPlugins {

    object Project {
        const val androidGradlePlugin =
            "com.android.tools.build:gradle:7.0.0-alpha15"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"

    }

    object Module {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val ktxSerialization = "kotlinx-serialization"
        const val kotlinKapt = "kotlin-kapt"
        const val daggerHilt = "dagger.hilt.android.plugin"

        const val kotlinAndroidExtensions = "kotlin-android-extensions"
    }

}

object AndroidSdk {
    const val min = 23
    const val compile = 30
    const val target = compile
}

//
object Deps {

    object Android {
        const val ktxCore = "androidx.core:core-ktx:1.3.2"
        const val ktxLifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01"
        const val material = "com.google.android.material:material:1.3.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-alpha02"
    }

    object JetpackCompose {
        private const val navVer = "1.0.0-alpha02"
        private const val pagingVer = "1.0.0-alpha02"

        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val activity = "androidx.activity:activity-compose:1.3.0-alpha07"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val icon = "androidx.compose.material:material-icons-core:$composeVersion"
        const val iconExtended = "androidx.compose.material:material-icons-extended:$composeVersion"
        const val liveData = "androidx.compose.runtime:runtime-livedata:$composeVersion"
        const val navigation = "androidx.navigation:navigation-compose:1.0.0-alpha10"
        const val paging = "androidx.paging:paging-compose:$pagingVer"

        const val lifecycleVM = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
    }

    object Networking {
        private const val ktorVer = "1.5.4"

        const val coil = "io.coil-kt:coil:1.2.1"
        const val coilCompose = "com.google.accompanist:accompanist-coil:0.8.1"

        const val ktor = "io.ktor:ktor-client-core:$ktorVer"
        const val ktorAndroid = "io.ktor:ktor-client-android:$ktorVer"
        const val ktorLogging = "io.ktor:ktor-client-logging-jvm:$ktorVer"
        const val ktorSerialization = "io.ktor:ktor-client-serialization:$ktorVer"
    }

    object Hilt {
        const val main = "com.google.dagger:hilt-android:$hiltVersion"
        const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    }


    object Others {
        const val ktxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0"
    }

}

object Libraries {
    private object Versions {
        const val jetpack = "1.0.0-beta01"
        const val constraintLayout = "1.1.2"
        const val ktx = "1.1.0-alpha05"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.1.0-alpha4"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}