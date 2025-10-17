package my.drivebit.clients

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.Navigator
import my.drivebit.mobile.di.mobileModule
import my.drivebit.mobile.screens.main.MainScreen
import my.drivebit.shared.storage.di.storageModule
import my.drivebit.ui.theme.DrivebitTheme
import my.drivebit.viewmodels.di.viewModelsModule
import org.koin.compose.KoinApplication
import org.koin.dsl.module

@Composable
actual fun App() {
    val context = LocalContext.current.applicationContext

    DrivebitTheme {
        KoinApplication(application = {
            modules(
                module {
                    single<Context> { context }
                },
                storageModule,
                viewModelsModule,
                mobileModule,
            )
        }) {
            Box(modifier = Modifier.fillMaxSize()) {
                Navigator(MainScreen())
            }
        }
    }
}
