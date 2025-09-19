package my.drivebit.clients.screens.splash

sealed interface SplashState {
    data object Init : SplashState
    data object Loading : SplashState
    data object Loaded : SplashState
}
