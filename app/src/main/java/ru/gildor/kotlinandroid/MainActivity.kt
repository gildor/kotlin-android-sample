package ru.gildor.kotlinandroid

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val fab: FloatingActionButton by findView(R.id.fab)
    val toolbar: Toolbar by findView(R.id.toolbar)
    val androidLogo: View by findView(R.id.android)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.please_replace), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.action), {
                        Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG).show();
                    })
                    .show()
        }

        androidLogo.setOnClickListener {
            ObjectAnimator.ofFloat(it, "rotation", 0f, 180f, 0f)
                    .setDuration(500)
                    .apply { interpolator = DecelerateInterpolator() }
                    .start()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
    }
}
