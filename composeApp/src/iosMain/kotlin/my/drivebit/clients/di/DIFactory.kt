package my.drivebit.clients.di

import my.drivebit.clients.screens.splash.SplashViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual object DIFactory : KoinComponent {
    actual fun getSplashViewModel(): SplashViewModel {
        return inject<SplashViewModel>().value
    }
}
