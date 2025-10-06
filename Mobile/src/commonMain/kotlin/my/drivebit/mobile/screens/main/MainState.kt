package my.drivebit.mobile.screens.main

sealed interface MainState {
    data object Init : MainState

    data object Ready : MainState
}
