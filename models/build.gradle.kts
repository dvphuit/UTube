plugins {
    id("com.android.library")
    id(BuildPlugins.Module.kotlinAndroid)
    id(BuildPlugins.Module.ktxSerialization)
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
    implementation(Deps.Others.ktxSerialization)
}