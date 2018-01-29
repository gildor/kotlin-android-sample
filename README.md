# Sample Kotlin Android app that demonstrates kapt 1.2.20 build error

This sample reproduces this build problem with Kapt:
https://youtrack.jetbrains.com/issue/KT-22493

Try to build this project:
```
./gradlew assembleDebug
```

You will get error 
```
java.util.NoSuchElementException: List is empty.
```

CI status shows logs and error
[![CI Status](https://circleci.com/gh/gildor/kotlin-android-sample/tree/KT-22493.svg?style=shield)](https://circleci.com/gh/gildor/kotlin-android-sample/tree/KT-22493)


Check class [Data](app/src/main/java/ru/gildor/kotlinandroid/Data.kt) and you will see the reason:
Import with `$` sign in name causes kapt crash
