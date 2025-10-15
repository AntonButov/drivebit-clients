package my.drivebit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Blue = Color(0xFF2962FF)

val BlueRed = Color(0xFF6B46C1)
val Red = Color(0xFFEC4899)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Gray300 = Color(0xFFE0E0E6)

private val DarkColorScheme =
    darkColorScheme(
        primary =White,
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
