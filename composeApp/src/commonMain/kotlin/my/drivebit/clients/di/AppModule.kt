package my.drivebit.clients.di

import my.drivebit.clients.screens.splash.SplashViewModel
import org.koin.dsl.module

val appModule =
    module {
        factory { SplashViewModel() }
    }
