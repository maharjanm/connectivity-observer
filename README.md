# Connectivity Observer

`connectivity-observer` is a lightweight Android library for observing network connectivity changes as a Kotlin `Flow`.

## Features

- Observe network state changes using `Flow`
- Emits distinct connectivity statuses:
  - `Available`
  - `Unavailable`
  - `Losing`
  - `Lost`
- Uses `ConnectivityManager.registerDefaultNetworkCallback`
- Minimum SDK: 24

## Installation

Add JitPack and the dependency.

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

```kotlin
// build.gradle.kts (module)
dependencies {
    implementation("com.github.maharjanm:connectivity-observer:1.0.0")
}
```

## Permission

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Usage

```kotlin
val observer = NetworkConnectivityObserver(applicationContext)

lifecycleScope.launch {
    observer.observe().collect { status ->
        Log.d("Connectivity", "Status: $status")
    }
}
```
