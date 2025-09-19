package my.drivebit.clients.di

import my.drivebit.clients.screens.splash.SplashViewModel
import kotlin.reflect.KClass

actual fun <T : Any> getScreenModel(clazz: KClass<T>): T {
    return when (clazz) {
        SplashViewModel::class -> SplashViewModel() as T
        else -> throw IllegalArgumentException("ScreenModel ${clazz.simpleName} not supported in Android target")
    }
}
