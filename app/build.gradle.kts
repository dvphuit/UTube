plugins {
    id(BuildPlugins.Module.androidApplication)
    id(BuildPlugins.Module.kotlinAndroid)
    id(BuildPlugins.Module.ktxSerialization)
    id(BuildPlugins.Module.kotlinKapt)
    id(BuildPlugins.Module.daggerHilt)
}

android {
    compileSdk = AndroidSdk.compile

    defaultConfig {
        this.applicationId = "dvp.app.utube"
        this.minSdk = AndroidSdk.min
        this.targetSdk = AndroidSdk.target
        this.versionCode = 1
        this.versionName = "1.0"
        this.testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        this.vectorDrawables{
            this.useSupportLibrary = true
        }
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

    kotlinOptions{
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures{
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}


dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Deps.Android.ktxCore)
    implementation(Deps.Android.ktxLifeCycleRuntime)
    implementation(Deps.Android.material)

    implementation(Deps.JetpackCompose.ui)
    implementation(Deps.JetpackCompose.material)
    implementation(Deps.JetpackCompose.activity)
    implementation(Deps.JetpackCompose.tooling)
    implementation(Deps.JetpackCompose.lifecycleVM)
    implementation(Deps.JetpackCompose.navigation)

    implementation(Deps.Networking.coil)
    implementation(Deps.Networking.coilCompose)

    implementation(Deps.Networking.ktor)
    implementation(Deps.Networking.ktorAndroid)
    implementation(Deps.Networking.ktorLogging)
    implementation(Deps.Networking.ktorSerialization)
    implementation(Deps.Others.ktxSerialization)

    implementation(Deps.Hilt.main)
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")
    kapt(Deps.Hilt.compiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}