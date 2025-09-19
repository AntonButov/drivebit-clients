package my.drivebit.clients.screens.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
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