package my.drivebit.clients

import androidx.compose.runtime.Composable
import my.drivebit.clients.web.SimpleWebApp

@Composable
actual fun App() {
    // Веб-версия - используем SimpleWebApp
    SimpleWebApp()
}
