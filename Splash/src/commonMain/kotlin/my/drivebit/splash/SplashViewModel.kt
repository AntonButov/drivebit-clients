package my.drivebit.splash

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : StateScreenModel<SplashState>(SplashState.Init) {
    init {
        screenModelScope.launch {
            delay(2000)
            mutableState.value = SplashState.Loaded
        }
    }
}
