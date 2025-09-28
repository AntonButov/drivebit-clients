package my.drivebit.clients

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.Navigator
import my.drivebit.clients.di.appModule
import my.drivebit.clients.di.platformModule
import my.drivebit.clients.screens.main.MainScreen
import my.drivebit.clients.theme.DrivebitTheme
import org.koin.compose.KoinApplication
import org.koin.dsl.module

@Composable
actual fun App() {
    val context = LocalContext.current

    DrivebitTheme {
        KoinApplication(application = {
            modules(
                module {
                    single<Context> { context }
                },
                appModule,
                platformModule,
            )
        }) {
            Box(modifier = Modifier.fillMaxSize()) {
                Navigator(MainScreen())
            }
        }
    }
}
