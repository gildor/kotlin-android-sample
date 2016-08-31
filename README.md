# Sample Kotlin Android app that shows incopability of kapt2 (eap-100) and Dagger2 

To reproduce just run clean build:
```
./gradlew clean assembleDebug
```

You will receive build exception:
```
:app:compileDebugKotlin
e: /build/path/kotlin-android-sample/MainActivity.kt: (41, 15): Unresolved reference: DaggerTestComponent
```

[Full log](full.log)

If you comment line `MainActivity.kt:41` build will be successful and then you can uncomment 41st line again and all non-clean builds will be successful too, so Dagger generates all code while build.
