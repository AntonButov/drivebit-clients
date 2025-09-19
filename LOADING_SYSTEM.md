# Система глобальных лоадеров

В проекте реализована глобальная система лоадеров с использованием Koin и Voyager для показа loading состояний на любых экранах.

## Архитектура

### 1. LoadingManager
Глобальный сервис для управления состоянием загрузки:
- **Состояние**: `LoadingState` с полями `isLoading`, `message`, `progress`
- **Методы**: `showLoading()`, `hideLoading()`, `showProgress()`, `updateProgress()`
- **Удобные методы**: `withLoading()`, `withProgress()`

### 2. GlobalLoader
Composable компонент, который отображается поверх всего приложения:
- **Полноэкранный оверлей** с полупрозрачным фоном
- **Круговой индикатор** для обычной загрузки
- **Линейный прогресс-бар** для загрузки с прогрессом
- **Сообщения** о текущем действии

### 3. InlineLoader
Компонент для встроенных лоадеров внутри экранов:
- **Компактный размер** для использования в списках и формах
- **Опциональное сообщение**

## Использование

### Базовое использование

```kotlin
class MyViewModel : StateScreenModel<MyState>(MyState()) {
    private val loadingManager = getScreenModel<LoadingManager>()
    
    fun loadData() {
        screenModelScope.launch {
            loadingManager.withLoading("Загрузка данных...") {
                // Ваша логика загрузки
                val data = apiService.getData()
                mutableState.value = mutableState.value.copy(data = data)
            }
        }
    }
}
```

### Загрузка с прогрессом

```kotlin
fun loadDataWithProgress() {
    screenModelScope.launch {
        loadingManager.withProgress("Загрузка с прогрессом...") { updateProgress ->
            // Обновляем прогресс
            repeat(10) { step ->
                kotlinx.coroutines.delay(200)
                updateProgress((step + 1) / 10f)
            }
            
            // Загружаем данные
            val data = apiService.getData()
            mutableState.value = mutableState.value.copy(data = data)
        }
    }
}
```

### Ручное управление

```kotlin
fun manualLoading() {
    screenModelScope.launch {
        loadingManager.showLoading("Начинаем загрузку...")
        
        try {
            // Ваша логика
            val result = performOperation()
            
            loadingManager.updateMessage("Обработка результата...")
            processResult(result)
            
        } finally {
            loadingManager.hideLoading()
        }
    }
}
```

### Встроенный лоадер

```kotlin
@Composable
fun MyScreen() {
    val isLoading by viewModel.isLoading.collectAsState()
    
    Column {
        if (isLoading) {
            InlineLoader("Загрузка...")
        } else {
            // Основной контент
        }
    }
}
```

## Примеры в проекте

### SearchViewModel
- **Обычный поиск**: `performSearch()` с `withLoading()`
- **Поиск с прогрессом**: `performSearchWithProgress()` с `withProgress()`

### FavoritesViewModel
- **Загрузка избранного**: `loadFavorites()` с `withLoading()`
- **Добавление/удаление**: ручное управление с `showLoading()`/`hideLoading()`

## Преимущества

- ✅ **Глобальный доступ** - лоадер доступен из любого экрана
- ✅ **Автоматическое управление** - автоматическое скрытие при завершении
- ✅ **Типобезопасность** - все методы типобезопасны
- ✅ **Гибкость** - поддержка обычной загрузки и прогресса
- ✅ **Удобство** - простые методы `withLoading()` и `withProgress()`
- ✅ **Консистентность** - единый стиль лоадеров во всем приложении

## Настройка

### Добавление в App.kt
```kotlin
@Composable
fun App() {
    KoinApplication(modules = listOf(appModule)) {
        DrivebitTheme {
            Box(modifier = Modifier.fillMaxSize()) {
                Navigator(SplashScreen())
                GlobalLoader() // Глобальный лоадер
            }
        }
    }
}
```

### Регистрация в Koin
```kotlin
val appModule = module {
    factoryOf(::LoadingManager) // Глобальный сервис
}
```

## Стилизация

Лоадеры используют Material Design 3:
- **Цвета**: `MaterialTheme.colorScheme.primary`
- **Типографика**: `MaterialTheme.typography`
- **Размеры**: адаптивные размеры для разных экранов

Можно легко кастомизировать в `GlobalLoader.kt` и `InlineLoader.kt`.
