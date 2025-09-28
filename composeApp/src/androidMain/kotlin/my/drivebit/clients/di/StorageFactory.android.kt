package my.drivebit.clients.di

import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.create
import org.koin.mp.KoinPlatform.getKoin

actual fun createStorage(): Storage {
    val context = getKoin().get<android.content.Context>()
    return create(context)
}
