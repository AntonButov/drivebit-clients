package my.drivebit.clients.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import my.drivebit.clients.theme.DrivebitTheme
import my.drivebit.clients.ui.icons.Icons
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    onBackClick?.let {
        TopAppBar(
            title = {
                Text(
                    text = title,
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.ArrowBackIcon,
                        contentDescription = "Back",
                    )
                }
            },
        )
    } ?: TopAppBar(
        title = {
            Text(
                text = title,
            )
        },
    )
}

@Composable
@Preview
fun ApplicationTopBarPreview() {
    DrivebitTheme {
        ApplicationTopBar(
            title = "Log In",
            onBackClick = {},
        )
    }
}
