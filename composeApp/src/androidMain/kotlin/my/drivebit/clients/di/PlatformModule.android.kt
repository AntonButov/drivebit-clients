package my.drivebit.clients.di

import my.drivebit.splash.SplashViewModel
import org.koin.dsl.module

val platformModule =
    module {
        factory { SplashViewModel() }
    }
