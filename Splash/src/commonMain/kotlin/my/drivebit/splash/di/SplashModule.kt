package my.drivebit.splash.di

import my.drivebit.splash.SplashViewModel
import org.koin.dsl.module

val splashModule =
    module {
        factory { SplashViewModel() }
    }
