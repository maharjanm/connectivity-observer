plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.github.maharjanm.connectivity"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Tell AGP which build variant to publish, and bundle a sources jar
    // so consumers can ctrl-click into your code in the IDE.
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

}

dependencies {
    implementation(libs.coroutines.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}

// JitPack builds run `publishToMavenLocal`, and this block defines
// the Maven coordinates of your artifact.
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.maharjanm"
                artifactId = "connectivity-observer"
                version = "1.0.0"
            }
        }
    }
}