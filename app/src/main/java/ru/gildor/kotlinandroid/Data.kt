package ru.gildor.kotlinandroid

import android.content.Intent
import android.os.Parcelable

import com.google.auto.value.AutoValue

@AutoValue
abstract class Data : Parcelable {

    abstract fun title(): String

    abstract fun number(): Int

    abstract fun intent(): Intent

    abstract fun toBuilder(): Builder

    @AutoValue.Builder
    abstract class Builder {
        abstract fun title(title: String): Builder

        abstract fun number(number: Int): Builder

        abstract fun intent(`object`: Intent): Builder

        abstract fun build(): Data
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
