package ru.gildor.kotlinandroid

import android.content.Intent
import android.os.Parcelable

interface IData : Parcelable {
    fun title(): String
    fun number(): Int
    fun intent(): Intent

    interface IBuilder<T : IData.IBuilder<T>> {
        fun title(title: String): T
        fun number(number: Int): T
        fun intent(obj: Intent): T
        fun build(): IData
    }
}