package ru.gildor.kotlinandroid

import android.util.Log
import java.net.URLConnection
import javax.inject.Inject

open class MyDependency @Inject constructor(val connection: URLConnection) {
    open fun doSomething() {
        Log.d("Dep", "I'm doing something " + connection)
    }

}