plugins {
    id("com.android.library")
    id(BuildPlugins.Module.kotlinAndroid)
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
    implementation(project(mapOf("path" to ":models")))
    implementation(Deps.Android.ktxCore)

    implementation(Deps.JetpackCompose.ui)
    implementation(Deps.JetpackCompose.material)
    implementation(Deps.JetpackCompose.tooling)

    implementation(Deps.Networking.coil)
    implementation(Deps.Networking.coilCompose)
}