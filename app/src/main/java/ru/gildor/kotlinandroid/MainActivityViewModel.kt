package ru.gildor.kotlinandroid

import android.animation.ObjectAnimator
import android.support.annotation.DrawableRes
import android.support.design.widget.Snackbar
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.Toast

class MainActivityViewModel(@DrawableRes val icon: Int) {
    fun rotate(view: View) {
        ObjectAnimator.ofFloat(view, "rotation", 0f, 180f, 0f, 360f)
                .setDuration(5000)
                .apply { interpolator = AnticipateOvershootInterpolator() }
                .start()
    }

    fun showSnackbar(view: View) {
        val context = view.context
        Snackbar.make(view, context.getString(R.string.please_replace), Snackbar.LENGTH_LONG)
                .setAction(context.getString(R.string.action), {
                    Toast.makeText(context, R.string.toast, Toast.LENGTH_LONG).show();
                })
                .show()
    }
}