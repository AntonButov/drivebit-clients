package my.drivebit.clients.di

import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.create

actual fun createStorage(): Storage = create()
