package my.drivebit.clients

import androidx.compose.runtime.Composable
import my.drivebit.clients.web.SimpleWebApp
import org.w3c.dom.Window

@Composable
actual fun App() {
    // Веб-версия - используем SimpleWebApp
    SimpleWebApp()
}
