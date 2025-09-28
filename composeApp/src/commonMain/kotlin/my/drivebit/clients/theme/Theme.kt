package my.drivebit.clients.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

private val DrivebitLightColors: ColorScheme =
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

private val DrivebitDarkColors: ColorScheme =
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
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors =
        if (useDarkTheme) {
            DrivebitDarkColors
        } else {
            DrivebitLightColors
        }

    MaterialTheme(colorScheme = colors, typography = MonofontoTypography()) {
        ProvideTextStyle(value = TextStyle.Default.copy(fontFamily = MonofontoFontFamily())) {
            Surface(modifier = Modifier.fillMaxSize(), color = colors.background) {
                content()
            }
        }
    }
}
