# Compose WASM Setup

## Структура проекта

Проект настроен для работы с Compose Multiplatform на трех платформах:
- **Android** - полноценное Android приложение с Koin DI
- **iOS** - нативное iOS приложение с Koin DI
- **WASM** - веб-приложение с Compose UI без Koin

## Архитектура DI

### Android и iOS
Используют Koin для dependency injection:
```kotlin
@Composable
actual fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        Navigator(MainScreen())
    }
}
```

### WASM
Использует простой провайдер без Koin:
```kotlin
@Composable
actual fun App() {
    DrivebitTheme {
        Navigator(MainScreen())
    }
}
```

## Получение ViewModels

Используется единый API для всех платформ:
```kotlin
val viewModel: MyViewModel = platformScreenModel()
```

Под капотом:
- **Android/iOS**: использует `koinScreenModel()` из voyager-koin
- **WASM**: использует ручное создание через `wasmScreenModel()`

## Команды для запуска

### WASM (Web)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Android
```bash
./gradlew :composeApp:assembleDebug
```

### iOS
Открыть `iosApp/` в Xcode

## Добавление новых ViewModels

1. Создайте ViewModel в `commonMain`
2. Добавьте в `AppModule.kt` для Koin (Android/iOS):
```kotlin
factory { MyViewModel(get()) }
```

3. Добавьте в `WasmDI.kt` для WASM:
```kotlin
MyViewModel::class -> MyViewModel(create())
```

4. Используйте в Screen:
```kotlin
val viewModel: MyViewModel = platformScreenModel()
```

## Особенности WASM

- Не использует Koin (не поддерживается)
- Storage использует localStorage браузера
- Все ViewModels создаются вручную
- UI полностью идентичен Android/iOS

