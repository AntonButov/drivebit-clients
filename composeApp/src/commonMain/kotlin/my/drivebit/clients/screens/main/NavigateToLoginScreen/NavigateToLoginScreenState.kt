package my.drivebit.clients.screens.main.NavigateToLoginScreen

sealed interface NavigateToLoginScreenState

data object Idle : NavigateToLoginScreenState

data object NavigateToLoginScreen : NavigateToLoginScreenState
