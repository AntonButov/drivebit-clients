package my.drivebit.clients.screens.main

sealed interface MainState {
    data object Init : MainState
    data object Ready : MainState
}
