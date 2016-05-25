#Reproduction of Android Lint bug with unused resources in Kotlin code

If you check project using Android Lint:

```
$ ./gradlew :app:lintDebug
```

You will see 12 unused resources warnings, but all of this resources is actually used on `MainActivity.kt`