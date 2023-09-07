plugins {
    id("com.android.library")
}

android {
    namespace = "com.vd.study.java_code"
    compileSdk = Build.CompileSdk

    defaultConfig {
        minSdk = Build.MinSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(Build.Libs.Android.CoreKtx)
    implementation(Build.Libs.Android.AppCompat)

    implementation(Build.Libs.Google.Material)

    testImplementation(Build.Libs.Testing.JUnit)
    androidTestImplementation(Build.Libs.Testing.JUnitEXT)
    androidTestImplementation(Build.Libs.Testing.EspressoCore)
}