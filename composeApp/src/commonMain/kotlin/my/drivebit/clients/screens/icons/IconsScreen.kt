package my.drivebit.clients.screens.icons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import my.drivebit.clients.theme.DrivebitTheme
import my.drivebit.clients.ui.components.ApplicationTopBar
import my.drivebit.clients.ui.icons.AllIconsPreview
import org.jetbrains.compose.ui.tooling.preview.Preview

class IconsScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                ApplicationTopBar(
                    title = "Icons Preview",
                )
            },
        ) { paddingValues ->
            AllIconsPreview(
                modifier = Modifier.padding(paddingValues),
            )
        }
    }
}

@Composable
@Preview
fun IconsScreenPreview() {
    DrivebitTheme {
        IconsScreen().Content()
    }
}
