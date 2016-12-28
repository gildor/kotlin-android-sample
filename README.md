# Sample Kotlin Android app that shows problem of kapt3 1.0.6 while test module build 

To reproduce just run clean build:
```
./gradlew assembleAndroidTest
```

You will receive build exception:
```
:app:kaptDebugAndroidTestKotlin
[kapt] Annotation processing classpath is not specified, skipping annotation processing
:app:compileDebugAndroidTestKotlin
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/DaggerTest.kt: (14, 9): Unresolved reference: DaggerTestComponent
```

App module works fine:
```
./gradlew assembleDebug
```

To reproduce this issue I just moved TestComponent to androidTest source root.
If you moved it to app source root build will be successful (but not clean, see below). 
If you comment dagger usage build will be successful too, but DaggerTestComponent will not be generated.

Also I see additional issue for clean builds.
Just try to assemble test apk:
```
./gradlew clean assembleAndroidTest
```

And you will see additional errors:
```
:app:kaptDebugAndroidTestKotlin
[kapt] Annotation processing classpath is not specified, skipping annotation processing
:app:compileDebugAndroidTestKotlin
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/DaggerTest.kt: (10, 9): Unresolved reference: DaggerTestComponent
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/TestComponent.kt: (11, 27): Unresolved reference: AppComponent
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/TestComponent.kt: (21, 50): Unresolved reference: MyDependency
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/TestComponent.kt: (22, 25): Unresolved reference: MyDependency
e: /Users/gildor/work/kotlin-android-sample/app/src/androidTest/java/ru/gildor/kotlinandroid/TestComponent.kt: (23, 13): 'doSomething' overrides nothing
```

Looks like if I clean build tests classes from main module is not available. 
But if you try to build again without `clean` you will see only error about DaggerTestComponent.
I'm not sure that it's related, and, actually, can be fixed if you run test build after app build.