package my.drivebit.shared.storage

/**
 * Простой интерфейс для работы с токеном авторизации
 */
interface Storage {
    /**
     * Проверяет, авторизован ли пользователь
     */
    fun isLogined(): Boolean

    /**
     * Сохраняет токен
     */
    fun saveToken(token: String)

    /**
     * Получает токен
     */
    fun getToken(): String?
}
