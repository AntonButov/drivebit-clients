package my.drivebit.clients.di

import my.drivebit.shared.storage.Storage
import org.koin.dsl.module

val appModule =
    module {
        single<Storage> { createStorage() }
    }
