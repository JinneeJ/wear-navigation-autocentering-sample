plugins {
    id("com.android.application").version("7.1.3")
    id("org.jetbrains.kotlin.android").version("1.6.10")
}

android {
    namespace = "com.doist.wear.auto.centering"
    setCompileSdkVersion(31)

    defaultConfig {
        applicationId = "com.doist.wear.auto.centering"
        targetSdk = 31
        minSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation("androidx.wear.compose:compose-material:1.0.0-alpha20")
    implementation("androidx.wear.compose:compose-navigation:1.0.0-alpha20")
    implementation("androidx.activity:activity-compose:1.3.1")
}