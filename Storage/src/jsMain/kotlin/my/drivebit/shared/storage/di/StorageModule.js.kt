package my.drivebit.shared.storage.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.StorageImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual val storageModule: Module =
    module {
        // ✅ Предоставляем Settings как отдельный сервис
        single<Settings> { StorageSettings() }
        
        single<Storage> {
            StorageImpl(get<Settings>())
        }
    }
