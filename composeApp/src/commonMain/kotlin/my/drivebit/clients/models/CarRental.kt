package my.drivebit.clients.models

import kotlinx.datetime.LocalDate

/**
 * Модель автомобиля для аренды
 */
data class Car(
    val id: String,
    val brand: String,
    val model: String,
    val year: Int,
    val pricePerDay: Double,
    val location: String,
    val imageUrl: String? = null,
    val features: List<String> = emptyList(),
    val rating: Double = 0.0,
    val reviewCount: Int = 0,
    val isAvailable: Boolean = true
) {
    val fullName: String
        get() = "$brand $model ($year)"
}

/**
 * Модель бронирования автомобиля
 */
data class CarBooking(
    val id: String,
    val car: Car,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val totalPrice: Double,
    val status: BookingStatus,
    val ownerName: String,
    val ownerPhone: String? = null
) {
    val durationInDays: Int
        get() = my.drivebit.clients.utils.DateUtils.calculateDaysInclusive(startDate, endDate)
    
    val pricePerDay: Double
        get() = totalPrice / durationInDays
}

/**
 * Статус бронирования
 */
enum class BookingStatus {
    PENDING,        // Ожидает подтверждения
    CONFIRMED,      // Подтверждено
    ACTIVE,         // Активная поездка
    COMPLETED,      // Завершена
    CANCELLED       // Отменена
}

/**
 * Модель поиска автомобилей
 */
data class CarSearchFilters(
    val location: String = "",
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val minPrice: Double? = null,
    val maxPrice: Double? = null,
    val features: List<String> = emptyList()
) {
    val hasValidDates: Boolean
        get() = startDate != null && endDate != null && startDate <= endDate
    
    val durationInDays: Int?
        get() = if (hasValidDates) {
            my.drivebit.clients.utils.DateUtils.calculateDaysInclusive(startDate!!, endDate!!)
        } else null
}
