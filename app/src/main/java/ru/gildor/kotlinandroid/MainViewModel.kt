package ru.gildor.kotlinandroid

import android.animation.ObjectAnimator
import android.content.Context
import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.support.design.widget.Snackbar
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast

class MainViewModel(private val context: Context) {
    fun showMessage() {
        Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
    }
    fun spinAndroid(view: View) {
        ObjectAnimator.ofFloat(view, "rotation", 0f, 180f, 0f).apply {
            duration = 500
            interpolator = DecelerateInterpolator()
        }.start()
    }

    fun fab(view: View) {
        Snackbar.make(view, context.getString(R.string.please_replace), Snackbar.LENGTH_LONG)
                .setAction(context.getString(R.string.action)) {
                    Toast.makeText(context, R.string.toast, Toast.LENGTH_LONG).show()
                }
                .show()
    }
}

@BindingAdapter("placeholder")
fun setPlaceholder(view: View, @DrawableRes placeholder: Int): Unit = TODO()