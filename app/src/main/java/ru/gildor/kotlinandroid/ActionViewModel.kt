package ru.gildor.kotlinandroid

import android.view.View

class ActionViewModel(
    val text: String,
    val action: () -> Unit
)
