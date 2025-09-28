package my.drivebit.shared.storage

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

/**
 * iOS реализация фабрики Storage
 */
fun create(): Storage {
    val settings: Settings = NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
    return StorageImpl(settings)
}
