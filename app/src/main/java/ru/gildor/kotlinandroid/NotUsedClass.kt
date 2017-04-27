package ru.gildor.kotlinandroid

class NotUsedClass {
    private fun notUsedMethod() {
        println("Some code")
        throw IllegalAccessException("This function not used!")
    }
}