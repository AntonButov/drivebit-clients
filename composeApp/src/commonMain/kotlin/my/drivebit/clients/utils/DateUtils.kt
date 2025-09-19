package my.drivebit.clients.utils

import kotlinx.datetime.*
import kotlin.time.Duration.Companion.days

object DateUtils {
    
    /**
     * Вычисляет количество дней между двумя датами
     * @param startDate дата начала
     * @param endDate дата окончания
     * @return количество дней
     */
    fun calculateDaysBetween(startDate: LocalDate, endDate: LocalDate): Int {
        return endDate.toEpochDays() - startDate.toEpochDays()
    }
    
    /**
     * Вычисляет количество дней между двумя датами (включая обе даты)
     * @param startDate дата начала
     * @param endDate дата окончания
     * @return количество дней (включая начальную и конечную даты)
     */
    fun calculateDaysInclusive(startDate: LocalDate, endDate: LocalDate): Int {
        return calculateDaysBetween(startDate, endDate) + 1
    }
    
    /**
     * Получает текущую дату
     * @return текущая дата
     */
    fun getCurrentDate(): LocalDate {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    }
    
    /**
     * Проверяет, является ли дата в будущем
     * @param date проверяемая дата
     * @return true если дата в будущем
     */
    fun isDateInFuture(date: LocalDate): Boolean {
        return date > getCurrentDate()
    }
    
    /**
     * Проверяет, является ли дата в прошлом
     * @param date проверяемая дата
     * @return true если дата в прошлом
     */
    fun isDateInPast(date: LocalDate): Boolean {
        return date < getCurrentDate()
    }
    
    /**
     * Форматирует дату для отображения
     * @param date дата для форматирования
     * @return отформатированная строка даты
     */
    fun formatDate(date: LocalDate): String {
        return "${date.dayOfMonth}.${date.monthNumber}.${date.year}"
    }
    
    /**
     * Форматирует период дат для отображения
     * @param startDate дата начала
     * @param endDate дата окончания
     * @return отформатированная строка периода
     */
    fun formatDateRange(startDate: LocalDate, endDate: LocalDate): String {
        val days = calculateDaysInclusive(startDate, endDate)
        return "${formatDate(startDate)} - ${formatDate(endDate)} ($days ${getDaysText(days)})"
    }
    
    /**
     * Возвращает правильную форму слова "день" в зависимости от количества
     * @param count количество дней
     * @return правильная форма слова
     */
    private fun getDaysText(count: Int): String {
        return when {
            count % 10 == 1 && count % 100 != 11 -> "день"
            count % 10 in 2..4 && count % 100 !in 12..14 -> "дня"
            else -> "дней"
        }
    }
    
    /**
     * Создает LocalDate из строки в формате "dd.MM.yyyy"
     * @param dateString строка с датой
     * @return LocalDate или null если формат неверный
     */
    fun parseDate(dateString: String): LocalDate? {
        return try {
            val parts = dateString.split(".")
            if (parts.size == 3) {
                LocalDate(parts[2].toInt(), parts[1].toInt(), parts[0].toInt())
            } else null
        } catch (e: Exception) {
            null
        }
    }
}
