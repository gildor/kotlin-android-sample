package ru.gildor.kotlinandroid

import android.databinding.DataBindingUtil
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import ru.gildor.kotlinandroid.databinding.ActivityMainBinding
import java.io.File
import java.net.URLConnection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val fab: FloatingActionButton by findView(R.id.fab)

    @Inject
    lateinit var connection: URLConnection
    @Inject
    lateinit var dep: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.builder().build().inject(this)
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = MainViewModel(this)

        initTestData()
        //If you comment the next line build will be successfull 
        testDependencies()
        setSupportActionBar(binding.toolbar)

        fab.setOnClickListener { view ->
        }
    }

    private fun testDependencies() {
        AsyncTask.execute {
            Log.d("DaggerDependency", connection.inputStream.reader().readText())
        }
        dep.doSomething()
    }

    private fun initTestData() {
        val testFile = File(applicationContext.cacheDir, "test.txt")
        testFile.writeText("this is test\nfile")
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
