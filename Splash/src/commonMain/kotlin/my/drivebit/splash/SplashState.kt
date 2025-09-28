package my.drivebit.splash

sealed interface SplashState {
    data object Init : SplashState

    data object Loading : SplashState

    data object Loaded : SplashState
}
