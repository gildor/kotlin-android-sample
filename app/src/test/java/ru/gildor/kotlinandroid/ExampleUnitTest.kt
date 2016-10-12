package ru.gildor.kotlinandroid

import android.content.Intent
import android.os.Parcelable
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun mocking() {
        val intent: Intent = mock {
            on { putExtra(any(), any<Parcelable>()) } doReturn it
            on { putExtra(any(), any<String>()) } doReturn it
            on { putExtra(any(), any<Int>()) } doReturn it
        }
        assertEquals(intent.putExtra("", ""), intent)
    }
}