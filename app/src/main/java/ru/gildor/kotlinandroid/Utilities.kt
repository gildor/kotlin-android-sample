package ru.gildor.kotlinandroid

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : View> findView(@IdRes id: Int) = object: ReadOnlyProperty<Activity, T> {
    var view: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        if (view == null) {
            view = thisRef.findViewById(id) as T;
        }
        return view!!
    }
}