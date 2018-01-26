package ru.gildor.kotlinandroid

import android.content.Intent

import com.google.auto.value.AutoValue
/**
 * KT-22493 This line causes kapt crash
 */
import ru.gildor.kotlinandroid.`$AutoValue_Data`.Builder as DataBuilder

@AutoValue
abstract class Data : IData {

    @AutoValue.Builder
    abstract class Builder : IData.IBuilder<Builder> {
        abstract override fun build(): Data
    }

    companion object {
        fun create(): Data {
            return AutoValue_Data("create title", 42, Intent())
        }

        fun builder(): Data.Builder {
            return DataBuilder().intent(Intent()).number(42).title("my title")
        }
    }
}
