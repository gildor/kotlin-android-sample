# Sample Kotlin Android app that demonstrate kapt3 task runs every time

To reproduce just run clean build:
```
./gradlew clean assembleDebug
```
Then change code of [NotUsedClass#notUsedMethod()](app/src/main/java/ru/gildor/kotlinandroid/NotUsedClass.kt)

And run incremental build:
```
./gradlew assembleDebug
```

You will see task `:app:kaptDebugKotlin` actually runs.
Also, you can try to change code again and exclude kapt task:
 
```
./gradlew assembleDebug -x :app:kaptDebugKotlin
```

In this case build will be faster.

Current behaviour:
Kapt task executes each time when sources changes, even if changed file has no annotation processing and even not used

Expected behaviour:
Task kaptDebugKotlin should be marked as UP-TO-DATE and skip AP step when AP not needed.