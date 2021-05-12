package architecture.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Settings(val isDarkMode: Boolean = false)