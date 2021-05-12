package dvp.app.utube

import android.app.Application
import architecture.core.data.datastore.DataStoreInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreInitializer.init(this)
    }
}