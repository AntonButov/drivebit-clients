package my.drivebit.storage

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.Storage
import org.w3c.dom.get
import org.w3c.dom.set
import kotlin.browser.localStorage

/**
 * Сервис для работы с localStorage в веб-браузере
 * Позволяет сохранять состояние между перезагрузками страницы
 */
interface StorageService {
    fun <T> save(key: String, value: T)
    fun <T> load(key: String, defaultValue: T): T
    fun remove(key: String)
    fun clear()
}

@Serializable
data class FilterState(
    val selected: String = "Все",
    val filters: List<FilterItem> = emptyList()
)

@Serializable
data class FilterItem(
    val icon: String,
    val title: String,
    val backgroundIcon: String,
)

/**
 * Реализация StorageService для веб-браузера
 * Использует localStorage для сохранения данных
 */
class WebStorageService : StorageService {
    private val storage: Storage = localStorage
    private val json = Json { 
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    override fun <T> save(key: String, value: T) {
        try {
            val jsonString = when (value) {
                is String -> value
                is Number -> value.toString()
                is Boolean -> value.toString()
                else -> json.encodeToString(value)
            }
            storage[key] = jsonString
        } catch (e: Exception) {
            console.error("Failed to save to localStorage:", e)
        }
    }

    override fun <T> load(key: String, defaultValue: T): T {
        return try {
            val value = storage[key]
            when (defaultValue) {
                is String -> (value ?: defaultValue) as T
                is Number -> {
                    when (defaultValue) {
                        is Int -> (value?.toIntOrNull() ?: defaultValue) as T
                        is Long -> (value?.toLongOrNull() ?: defaultValue) as T
                        is Double -> (value?.toDoubleOrNull() ?: defaultValue) as T
                        is Float -> (value?.toFloatOrNull() ?: defaultValue) as T
                        else -> defaultValue
                    }
                }
                is Boolean -> (value?.toBooleanStrictOrNull() ?: defaultValue) as T
                else -> {
                    if (value != null) {
                        json.decodeFromString(defaultValue::class.serializer(), value)
                    } else {
                        defaultValue
                    }
                }
            }
        } catch (e: Exception) {
            console.error("Failed to load from localStorage:", e)
            defaultValue
        }
    }

    override fun remove(key: String) {
        storage.removeItem(key)
    }

    override fun clear() {
        storage.clear()
    }
}

/**
 * Расширения для удобной работы с фильтрами
 */
object FilterStorage {
    private const val FILTER_STATE_KEY = "drivebit_filter_state"
    
    fun saveFilterState(state: FilterState, storageService: StorageService) {
        storageService.save(FILTER_STATE_KEY, state)
    }
    
    fun loadFilterState(storageService: StorageService): FilterState {
        return storageService.load(FILTER_STATE_KEY, FilterState())
    }
    
    fun saveSelectedFilter(selected: String, storageService: StorageService) {
        val currentState = loadFilterState(storageService)
        val newState = currentState.copy(selected = selected)
        saveFilterState(newState, storageService)
    }
}
