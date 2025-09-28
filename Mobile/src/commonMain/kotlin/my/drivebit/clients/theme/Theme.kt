package my.drivebit.clients.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BlueRed = Color(0xFFE53E3E)

private val DarkColorScheme =
    darkColorScheme(
        primary = BlueRed,
        secondary = BlueRed,
        tertiary = BlueRed,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = BlueRed,
        secondary = BlueRed,
        tertiary = BlueRed,
    )

@Composable
fun DrivebitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content,
    )
}
