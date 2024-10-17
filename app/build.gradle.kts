plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android) // Si no estás usando Kotlin, puedes remover esta línea
}

android {
    namespace = "com.example.monitoreoconsumodelhogar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.monitoreoconsumodelhogar"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = false // Si no estás usando Jetpack Compose, esta línea debe estar en false
    }
}

dependencies {
    implementation(libs.androidx.recyclerview)
    dependencies {
        implementation("androidx.core:core-ktx:1.8.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
        implementation("androidx.appcompat:appcompat:1.3.1")
        implementation(libs.androidx.recyclerview.v121)
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.3")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    }
}
