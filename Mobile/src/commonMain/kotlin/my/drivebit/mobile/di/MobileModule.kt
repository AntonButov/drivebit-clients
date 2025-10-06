package my.drivebit.mobile.di

import my.drivebit.auth.di.authModule
import my.drivebit.splash.di.splashModule
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Mobile module - combines all feature modules needed for mobile app
 *
 * Includes:
 * - authModule - authentication (login, registration)
 * - splashModule - splash screen logic
 */
val mobileModule: Module =
    module {
        includes(
            authModule,
            splashModule,
        )
    }
