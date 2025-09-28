package my.drivebit.shared.storage

import android.content.Context
import androidx.preference.PreferenceManager
import com.russhwolf.settings.SharedPreferencesSettings

fun create(context: Context): Storage {
    val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
    val settings = SharedPreferencesSettings(sharedPrefs)
    return StorageImpl(settings)
}
