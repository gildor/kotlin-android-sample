package ru.gildor.kotlinandroid

import android.animation.ObjectAnimator
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import butterknife.Bind
import butterknife.ButterKnife
import java.io.File
import java.net.URLConnection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val fab: FloatingActionButton by findView(R.id.fab)
    val toolbar: Toolbar by findView(R.id.toolbar)
    @Bind(R.id.android)
    internal lateinit var androidLogo: View

    @Inject
    lateinit var connection: URLConnection
    @Inject
    lateinit var dep: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        val testFile = File(applicationContext.cacheDir, "test.txt")
        testFile.writeText("this is test\nfile")
        //If you comment the next line build will be successfull 
        dep = DaggerAppComponent.builder().build().dependency()
        AsyncTask.execute {
            Log.d("DaggerDependency", connection.inputStream.reader().readText())
        }
        dep.doSomething()
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.please_replace), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.action)) {
                        Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG).show()
                    }
                    .show()
        }

        androidLogo.setOnClickListener {
            ObjectAnimator.ofFloat(it, "rotation", 0f, 180f, 0f).apply {
                duration = 500
                interpolator = DecelerateInterpolator()
            }.start()
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
