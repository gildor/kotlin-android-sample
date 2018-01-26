package ru.gildor.kotlinandroid

import android.content.Intent

import com.google.auto.value.AutoValue

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
            return `$AutoValue_Data`.Builder().intent(Intent()).number(42).title("my title")
        }
    }
}
