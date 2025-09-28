package my.drivebit.shared.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

object DateUtils {
    /**
     * Получить текущую дату и время
     */
    fun getCurrentDateTime(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    /**
     * Получить текущий timestamp
     */
    fun getCurrentTimestamp(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }

    /**
     * Форматировать дату в строку
     */
    fun formatDate(dateTime: LocalDateTime): String {
        return "${dateTime.dayOfMonth}.${dateTime.monthNumber}.${dateTime.year}"
    }
}
