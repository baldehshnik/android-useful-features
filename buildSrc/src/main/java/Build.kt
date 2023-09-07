object Build {

    const val TargetSdk = 33
    const val CompileSdk = 33
    const val MinSdk = 24

    object Libs {

        object Android {
            const val CoreKtx = "androidx.core:core-ktx:1.9.0"
            const val AppCompat = "androidx.appcompat:appcompat:1.6.1"

            const val ComposeMaterial3 = "androidx.compose.material3:material3:1.1.1"
            const val ComposeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"
        }

        object Google {
            const val DaggerVersion = "2.48"

            const val Material = "com.google.android.material:material:1.9.0"
            const val Dagger = "com.google.dagger:dagger:$DaggerVersion"
            const val DaggerCompiler = "com.google.dagger:dagger-compiler:$DaggerVersion"
        }

        object Testing {
            const val JUnit = "junit:junit:4.13.2"
            const val JUnitEXT = "androidx.test.ext:junit:1.1.5"
            const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }

    object Modules {
        const val JavaCode = ":java-code"
        const val KotlinCode = ":kotlin-code"
    }
}