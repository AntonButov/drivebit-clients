# Auth Module

Модуль аутентификации для Drivebit приложения.

## Компоненты

### LoginScreen
Экран входа в систему с полями для выбора страны и ввода номера телефона.

### ApplicationTopBar
Переиспользуемый компонент верхней панели с кнопкой "Назад".

### NavigateToLoginScreenViewModel
ViewModel для управления состоянием навигации к экрану входа.

## Использование

```kotlin
// В Mobile модуле
val loginViewModel: NavigateToLoginScreenViewModel = koinScreenModel()
val authState by loginViewModel.state.collectAsState()

when (authState) {
    NavigateToLoginScreenState.Idle -> {
        // Показать основной контент
    }
    NavigateToLoginScreenState.NavigateToLoginScreen -> {
        navigator.push(LoginScreen())
    }
}
```

## Зависимости

- Storage модуль для сохранения токенов
- Voyager для навигации
- Koin для dependency injection
- Compose Multiplatform для UI

## Сборка

```bash
./gradlew :Auth:assembleDebug
```

## Интеграция

Auth модуль интегрирован с Mobile модулем и готов к использованию в приложении.
