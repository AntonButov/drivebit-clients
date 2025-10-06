package my.drivebit.clients.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen

class MainWeb : Screen {
    @Composable
    override fun Content() {
        Text(
            text = "Hello World",
            color = Color.Black,
        )
    }
}
