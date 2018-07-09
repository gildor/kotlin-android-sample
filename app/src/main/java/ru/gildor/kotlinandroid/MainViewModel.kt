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

    // Option 1 action declaration:
    // All properties and behavior encapsulated in ActionViewModel
    val someAction = ActionViewModel("Option 1") {
        Toast.makeText(
            context,
            "Option 1 clicked: Check sources for implementation details!",
            Toast.LENGTH_SHORT
        ).show()
    }

    // Option 2 action declaration:
    // Property and action part of root view model and we just set them to button binding
    val action2 = "Option 2"
    fun onAction2() {
        Toast.makeText(
            context,
            "Option 2 clicked: Check sources for implementation details!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
