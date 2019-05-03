# RoomDB-Example
Example of RoomDB

Add cái này trước đã
```kotlin
apply plugin: 'kotlin-kapt'
```
Add RoomDB
```
// Room components
implementation "android.arch.persistence.room:runtime:$rootProject.roomVersion"
kapt "android.arch.persistence.room:compiler:$rootProject.roomVersion"
androidTestImplementation "android.arch.persistence.room:testing:$rootProject.roomVersion"

// Lifecycle components
implementation "android.arch.lifecycle:extensions:$rootProject.archLifecycleVersion"
kapt "android.arch.lifecycle:compiler:$rootProject.archLifecycleVersion"

// Coroutines
api "org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutines"
api "org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutines"
```

tiếp nè
```kotlin
android {
    ...
    kotlin {
        experimental {
            coroutines "enable"
        }
    }
}
```

thêm cái này nữa ở Project:RoomDB
```
ext {
   roomVersion = '1.1.1'
   archLifecycleVersion = '1.1.1'
   coroutines = '0.26.1'
}
```


-> [Entities RoomDB](https://developer.android.com/training/data-storage/room/defining-data.html)

