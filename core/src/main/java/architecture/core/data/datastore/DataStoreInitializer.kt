package architecture.core.data.datastore

import android.content.Context
import architecture.core.data.datastore.store.AppSettings

object DataStoreInitializer {

    private val providers = listOf<DataStoreProvider>(AppSettings)

    fun init(context: Context) {
        providers.forEach { it.init(context) }
    }
}