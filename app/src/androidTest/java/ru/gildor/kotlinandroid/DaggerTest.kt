package ru.gildor.kotlinandroid

import java.io.File

/**
 * [Testing Fundamentals](http://d.android.com/tools/testing/testing_android.html)
 */
class DaggerTest {
    fun daggerTest() {
        DaggerTestComponent.builder()
                .testModule(TestModule(File(".").toURI().toURL()))
                .build()
    }
}