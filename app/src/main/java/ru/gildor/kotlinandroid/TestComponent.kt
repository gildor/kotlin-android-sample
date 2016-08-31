package ru.gildor.kotlinandroid

import android.util.Log
import dagger.Component
import dagger.Module
import dagger.Provides
import java.net.URL
import java.net.URLConnection

@Component(modules = arrayOf(TestModule::class))
interface TestComponent : AppComponent {
    fun dep(): MyDependency
}

@Module
class TestModule(private val path: URL) {
    @Provides
    fun testConnection(): URLConnection {
        return path.openConnection()
    }

    @Provides
    fun myDependency(connection: URLConnection): MyDependency {
        return object : MyDependency(connection) {
            override fun doSomething() {
                Log.d("TestDependency", "Doing tests")
            }

        }
    }
}

@Retention(AnnotationRetention.RUNTIME)
annotation class AssetsPath
