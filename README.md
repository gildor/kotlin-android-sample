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


Check class [Data](app/src/main/java/ru/gildor/kotlinandroid/Data.kt) and you will see the reason:
Import with `$` sign in name causes kapt crash
