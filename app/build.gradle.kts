
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.cash.sqldelight)

    id(libs.plugins.google.devtools.ksp.get().pluginId)
}

android {
    namespace = "com.example.sqldelightnoteapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sqldelightnoteapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.atest.ext.junit)
    androidTestImplementation(libs.atestespresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.test.ui.junit4)
    debugImplementation(libs.debug.ui.tooling)
    debugImplementation(libs.debug.ui.tooling)

//    Compose dependencies
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.navigation.compose)
    implementation(libs.material.icons.extended)
    implementation(libs.hilt.navigation.compose)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.android.compiler)


    //sqldelight
    implementation(libs.cash.sqldelight.android.driver)
    implementation(libs.cash.sqldelight.coRx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}


sqldelight {
    databases {
        create("NoteDatabase") {
            packageName.set("com.example.sqldelightSpecial")
        }
    }
}