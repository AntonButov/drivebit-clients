package my.drivebit.auth

sealed interface NavigateToLoginScreenState

data object Idle : NavigateToLoginScreenState

data object NavigateToLoginScreen : NavigateToLoginScreenState
