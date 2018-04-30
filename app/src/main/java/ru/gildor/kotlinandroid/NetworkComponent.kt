package ru.gildor.kotlinandroid

import dagger.Component
import dagger.Module
import dagger.Provides
import java.net.URL
import java.net.URLConnection

@Component(modules = arrayOf(NetworkModule::class))
interface AppComponent {
    fun connection(): URLConnection

    fun dependency(): MyDependency

    fun inject(activity: MainActivity)
}

@Module
class NetworkModule {
    @Provides
    fun connection(): URLConnection {
        return URL("http://example.net").openConnection()
    }

    @Provides
    fun data(): Data {
        return Data.builder().title("network module title").build()
    }
}