plugins {
    id("com.android.library")
    id(BuildPlugins.Module.kotlinAndroid)
    id(BuildPlugins.Module.ktxSerialization)
    id(BuildPlugins.Module.kotlinKapt)
    id(BuildPlugins.Module.daggerHilt)
}

android {
    compileSdk = AndroidSdk.compile
    buildToolsVersion = "30.0.3"
    defaultConfig {
        this.minSdk = AndroidSdk.min
        this.targetSdk = AndroidSdk.target
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.Android.ktxCore)
    implementation(Deps.Android.dataStore)

    implementation(Deps.Networking.ktor)
    implementation(Deps.Networking.ktorAndroid)
    implementation(Deps.Networking.ktorLogging)
    implementation(Deps.Networking.ktorSerialization)
    implementation(Deps.Others.ktxSerialization)

    implementation(Deps.Hilt.main)
    kapt(Deps.Hilt.compiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}