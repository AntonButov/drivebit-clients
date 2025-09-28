package my.drivebit.clients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import my.drivebit.clients.screens.MainWeb
import my.drivebit.clients.theme.DrivebitTheme

@Composable
actual fun App() {
    DrivebitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Navigator(MainWeb())
        }
    }
}
