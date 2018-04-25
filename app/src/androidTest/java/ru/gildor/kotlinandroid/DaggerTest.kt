package ru.gildor.kotlinandroid

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

/**
 * [Testing Fundamentals](http://d.android.com/tools/testing/testing_android.html)
 */
class DaggerTest {

    private val testComponent = DaggerTestComponent.builder()
            .testModule(TestModule(File("/tmp/file").toURI().toURL()))
            .build()

    @Test
    fun testUrl() {
        assertEquals("file:/tmp/file", testComponent.connection().url.toString())
    }
}