package ru.gildor.kotlinandroid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Executable
import org.junit.jupiter.api.Test

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @Test
    @DisplayName("Example addition test")
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        assertAll("Multiple asserts",
                Executable { assertFalse(true, "This is wrong") },
                Executable { assertTrue(false, "This is wrong too") }
        )
    }
}