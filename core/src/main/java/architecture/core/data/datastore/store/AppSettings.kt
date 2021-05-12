package architecture.core.data.datastore.store

import androidx.datastore.preferences.preferencesKey
import architecture.core.data.datastore.DataStoreProvider
import architecture.core.data.datastore.store.AppSettings.Keys.SETTINGS
import architecture.core.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object AppSettings : DataStoreProvider() {

    override fun prefName() = "settings"

    fun getSettings(): Flow<Settings> {
        return getValue(SETTINGS, DEFAULT.EMPTY_OBJ).map {
            Json.decodeFromString(it)
        }
    }

    object Keys {
        val SETTINGS = preferencesKey<String>("SETTINGS")
    }

    object DEFAULT {
        const val EMPTY_OBJ = "{}"
        const val EMPTY_STR = ""
    }
}