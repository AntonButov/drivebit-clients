package my.drivebit.shared.storage

import com.russhwolf.settings.Settings

/**
 * Фабрика для создания Storage
 */
object StorageFactory {
    /**
     * Создает Storage с использованием переданных настроек
     */
    fun create(settings: Settings): Storage {
        return StorageImpl(settings)
    }

    /**
     * Создает Storage с настройками по умолчанию для платформы
     * Пользователь должен передать Settings из платформо-специфичного кода
     */
    fun createDefault(settings: Settings): Storage {
        return StorageImpl(settings)
    }
}
