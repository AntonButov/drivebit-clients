package my.drivebit.shared.storage.di

import org.koin.core.module.Module

/**
 * Storage module - provides persistent key-value storage
 *
 * Storage instance must be created platform-specifically.
 * Use expect/actual pattern to provide platform-specific Storage factory.
 */
expect val storageModule: Module
