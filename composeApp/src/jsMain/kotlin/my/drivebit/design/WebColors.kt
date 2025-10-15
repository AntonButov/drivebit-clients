package my.drivebit.design

import my.drivebit.ui.theme.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.CSSColorValue

/**
 * Веб-специфичные цвета для Compose for Web
 * Конвертирует цвета из существующей темы в CSSColorValue
 */
object WebDrivebitColors {
    // Основные цвета из темы
    val Blue: CSSColorValue = Color(Blue.toHexString())
    val BlueRed: CSSColorValue = Color(BlueRed.toHexString())
    val Red: CSSColorValue = Color(Red.toHexString())
    
    // Нейтральные цвета из темы
    val White: CSSColorValue = Color(White.toHexString())
    val Black: CSSColorValue = Color(Black.toHexString())
    val Gray300: CSSColorValue = Color(Gray300.toHexString())
    
    // Дополнительные цвета (добавляем к существующей теме)
    val Gray100: CSSColorValue = Color("#F5F5F5")
    val Gray500: CSSColorValue = Color("#9E9E9E")
    val Gray900: CSSColorValue = Color("#212121")
    
    // Цвета состояний
    val Success: CSSColorValue = Color("#4CAF50")
    val Warning: CSSColorValue = Color("#FF9800")
    val Error: CSSColorValue = Color("#F44336")
}

/**
 * Расширение для конвертации androidx.compose.ui.graphics.Color в hex строку
 */
fun androidx.compose.ui.graphics.Color.toHexString(): String {
    return String.format("#%08X", value)
}
