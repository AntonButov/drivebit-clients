package my.drivebit.clients

import my.drivebit.shared.storage.di.storageModule
import my.drivebit.viewmodels.di.viewModelsModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(
            storageModule,
            viewModelsModule,
            appModule,
        )
    }
}

private val appModule =
    module {
    }
