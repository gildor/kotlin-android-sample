# Android app with Kotlin + kapt2 and Data Bindings build error

This is simple app that use Kotlin 1.0.4-eap-100 with kapt2 and DataBindings

To reproduce just try to build:

```
./gradlew assembleDebug
```

Build fails with exception:

```
cannot generate view binders java.lang.StringIndexOutOfBoundsException: String index out of range: -1
        at java.lang.String.substring(String.java:1967)
        at android.databinding.tool.reflection.annotation.AnnotationTypeUtil.getDescription(AnnotationTypeUtil.java:87)
        at android.databinding.tool.reflection.annotation.AnnotationTypeUtil.getDescription(AnnotationTypeUtil.java:47)
        ...
```

[Full log](kapt-build-fail.log)