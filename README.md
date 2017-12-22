# Sample Kotlin Android app that demonstrates kapt 1.2.20-eap-11 build error

This sample reproduces this build problem with Kapt:
https://youtrack.jetbrains.com/issue/KT-21936

If you change Kotlin version to 1.2.10 everything works

To reproduce just try to assemble project:

```
./gradlew assembleDebug
```

With `clean` build you will get the same problem.

You will see this in error logs:

```
> Task :app:compileDebugJavaWithJavac FAILED
/Users/gildor/work/kotlin-android-sample/app/build/generated/source/kapt/debug/ru/gildor/kotlinandroid/$AutoValue_Data.java:5: error: package kapt.internal does not exist
import kapt.internal.KaptSignature;
                    ^
/Users/gildor/work/kotlin-android-sample/app/build/generated/source/kapt/debug/ru/gildor/kotlinandroid/$AutoValue_Data.java:30: error: cannot find symbol
  @KaptSignature(value = "title()Ljava/lang/String;")
   ^
  symbol:   class KaptSignature
  location: class $AutoValue_Data
/Users/gildor/work/kotlin-android-sample/app/build/generated/source/kapt/debug/ru/gildor/kotlinandroid/$AutoValue_Data.java:36: error: cannot find symbol
  @KaptSignature(value = "number()I")
   ^
  symbol:   class KaptSignature
  location: class $AutoValue_Data
/Users/gildor/work/kotlin-android-sample/app/build/generated/source/kapt/debug/ru/gildor/kotlinandroid/$AutoValue_Data.java:43: error: cannot find symbol
  @KaptSignature(value = "intent()Landroid/content/Intent;")
   ^
  symbol:   class KaptSignature
  location: class $AutoValue_Data
4 errors
```