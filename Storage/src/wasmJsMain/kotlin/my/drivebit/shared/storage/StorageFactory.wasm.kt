package my.drivebit.shared.storage

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings

internal class StorageWasm(
    private val settings: Settings,
) : Storage {
    companion object {
        private const val TOKEN_KEY = "auth_token"
    }

    override fun isLogined(): Boolean {
        val token = settings.getString(TOKEN_KEY, "")
        return token.isNotEmpty()
    }

    override fun saveToken(token: String) {
        settings.putString(TOKEN_KEY, token)
    }

    override fun getToken(): String? {
        val token = settings.getString(TOKEN_KEY, "")
        return if (token.isEmpty()) null else token
    }
}

fun create(): Storage {
    val settings: Settings = StorageSettings()
    return StorageWasm(settings)
}
