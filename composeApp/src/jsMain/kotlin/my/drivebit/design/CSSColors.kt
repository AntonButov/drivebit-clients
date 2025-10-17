package my.drivebit.design

import my.drivebit.ui.theme.ColorsDriveBit
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

/**
 * CSS-версии цветов для использования в Compose Web
 * Используют только цвета из Theme.kt
 */
object CSSColors {
    // Основные цвета из Theme.kt
    val Black: CSSColorValue = ColorsDriveBit.Black.toCSSColor()
    val White: CSSColorValue = ColorsDriveBit.White.toCSSColor()
    val Gray300: CSSColorValue = ColorsDriveBit.Gray300.toCSSColor()

    // Акцентные цвета из Theme.kt
    val Blue: CSSColorValue = ColorsDriveBit.Blue.toCSSColor()
    val BlueRed: CSSColorValue = ColorsDriveBit.BlueRed.toCSSColor()
    val Red: CSSColorValue = ColorsDriveBit.Red.toCSSColor()
}

/**
 * Расширение для преобразования Compose Color в CSSColorValue
 */
fun androidx.compose.ui.graphics.Color.toCSSColor(): CSSColorValue =
    rgb(
        (red * 255).toInt(),
        (green * 255).toInt(),
        (blue * 255).toInt(),
    )
