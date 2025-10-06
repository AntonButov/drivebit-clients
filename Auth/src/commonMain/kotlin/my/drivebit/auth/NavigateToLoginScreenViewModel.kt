package my.drivebit.auth

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import my.drivebit.shared.storage.Storage

class NavigateToLoginScreenViewModel(
    private val store: Storage,
) : StateScreenModel<NavigateToLoginScreenState>(Idle) {
    fun checkLogin() {
        mutableState.update {
            if (store.isLogined()) {
                Idle
            } else {
                NavigateToLoginScreen
            }
        }
    }
}
