package my.drivebit.shared.storage.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.StorageImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val storageModule: Module =
    module {
        single<Storage> {
            val settings: Settings = NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
            StorageImpl(settings)
        }
    }
