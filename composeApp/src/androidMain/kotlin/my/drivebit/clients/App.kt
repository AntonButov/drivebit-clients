package my.drivebit.clients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.Navigator
import my.drivebit.clients.di.appModule
import my.drivebit.clients.screens.main.MainScreen
import org.koin.compose.KoinApplication

@Composable
actual fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            Navigator(MainScreen())
        }
    }
}
