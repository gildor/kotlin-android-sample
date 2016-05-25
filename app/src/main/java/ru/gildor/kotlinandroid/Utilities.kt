package ru.gildor.kotlinandroid

import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.widget.ImageView

@BindingAdapter("src")
fun setVectorDrawable(view: ImageView, @DrawableRes res: Int) {
    view.setImageResource(res)
}