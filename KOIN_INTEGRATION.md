# Koin Integration with Voyager

Этот проект теперь использует [Voyager с Koin интеграцией](https://voyager.adriel.cafe/screenmodel/koin-integration/) для управления ViewModel через dependency injection.

## Что было добавлено

### 1. Зависимости
- `cafe.adriel.voyager:voyager-koin` - интеграция Voyager с Koin
- `io.insert-koin:koin-core` - основной Koin
- `io.insert-koin:koin-compose` - Koin для Compose

### 2. Структура
```
composeApp/src/commonMain/kotlin/my/drivebit/clients/
├── di/
│   └── AppModule.kt          # Koin модули для ViewModel
├── screens/
│   ├── splash/
│   │   ├── SplashScreen.kt   # Использует getScreenModel<SplashViewModel>()
│   │   └── SplashViewModel.kt
│   └── main/tabs/
│       ├── SearchTab.kt      # Использует getScreenModel<SearchViewModel>()
│       └── SearchViewModel.kt
└── App.kt                    # Инициализация Koin
```

## Как использовать

### 1. Создание ViewModel
```kotlin
class MyViewModel : StateScreenModel<MyState>(MyState()) {
    // Ваша логика
}
```

### 2. Регистрация в Koin модуле
```kotlin
// В AppModule.kt
val appModule = module {
    factoryOf(::MyViewModel)
}
```

### 3. Использование в Screen
```kotlin
class MyScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MyViewModel>()
        val state by viewModel.state.collectAsState()
        
        // Ваш UI
    }
}
```

## Преимущества

- ✅ **Dependency Injection** - автоматическое управление зависимостями
- ✅ **Lifecycle Management** - автоматическое управление жизненным циклом ViewModel
- ✅ **Testability** - легко тестировать с mock объектами
- ✅ **Scalability** - легко добавлять новые ViewModel
- ✅ **Type Safety** - типобезопасность с generics

## Примеры

### SplashViewModel
- Использует `StateScreenModel` для управления состоянием
- Автоматически переходит в состояние Loading, затем Loaded
- Интегрирован с Koin через `getScreenModel<SplashViewModel>()`

### SearchViewModel
- Управляет состоянием поиска (query, isLoading, results)
- Содержит методы для обновления запроса и выполнения поиска
- Показывает пример реального использования с UI

## Добавление новых ViewModel

1. Создайте ViewModel класс, наследующий от `StateScreenModel`
2. Добавьте его в `AppModule.kt` с помощью `factoryOf(::YourViewModel)`
3. Используйте в Screen с `getScreenModel<YourViewModel>()`

## Navigator Scoped ViewModel

Для ViewModel, привязанных к конкретному Navigator:

```kotlin
val navigator = LocalNavigator.currentOrThrow
val screenModel = navigator.getNavigatorScreenModel<MyViewModel>()
```

Это полезно для ViewModel, которые должны жить только пока активен определенный Navigator.
