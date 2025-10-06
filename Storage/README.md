# Shared Storage Module

Простой кросплатформенный модуль для хранения токена авторизации.

## Интерфейс

```kotlin
interface Storage {
    fun isLogined(): Boolean
    fun saveToken(token: String)
    fun getToken(): String?
}
```

## Использование

### 1. Создание Storage

```kotlin
// Android
val settings = SharedPreferencesSettings()
val storage = StorageFactory.create(settings)

// iOS  
val settings = NSUserDefaultsSettings()
val storage = StorageFactory.create(settings)

// JS/WASM
val settings = StorageSettings()
val storage = StorageFactory.create(settings)
```

### 2. Работа с токеном

```kotlin
// Сохранение токена
storage.saveToken("your_auth_token_here")

// Проверка авторизации
if (storage.isLogined()) {
    println("User is logged in")
} else {
    println("User is not logged in")
}

// Получение токена
val token = storage.getToken()
```

## Тесты

Модуль полностью покрыт тестами. Запуск тестов:

```bash
./gradlew :Storage:test
```

## Зависимости

- `multiplatform-settings` - для кросплатформенного хранения данных
- `kotlinx-serialization` - для сериализации (если понадобится в будущем)
