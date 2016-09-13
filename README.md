# Android app with Kotlin + kapt2 and Data Bindings build error

This is simple app that use Kotlin 1.0.4-eap-114 with kapt2 and DataBindings

To reproduce build error just try to build:

```
./gradlew assembleDebug
```

Build fails with exception:

```
data binding error ****msg:Cannot find the getter for attribute 'android:text' with value type T on android.widget.EditText
```

Please check Kotlin issue for updates - https://youtrack.jetbrains.com/issue/KT-13823
