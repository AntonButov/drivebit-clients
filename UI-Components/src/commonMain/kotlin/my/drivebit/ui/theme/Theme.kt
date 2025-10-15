package my.drivebit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
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

private val DarkColorScheme: ColorScheme =
    lightColorScheme(
        primary = Black,
        onPrimary = White,
        background = White,
        surface = White,
        onSurface = Black,
        surfaceVariant = Gray300,
        surfaceContainer = White,
        outline = Blue,
    )

private val LightColorScheme: ColorScheme =
    darkColorScheme(
        primary = White,
        onPrimary = Black,
        background = Black,
        surface = Black,
        surfaceVariant = Gray300,
        surfaceContainer = Black,
        outline = Blue,
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
