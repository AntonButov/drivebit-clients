# Dependency Injection Guide для CommonViewModels

## Как правильно работать с Koin модулями

### 1. Структура модулей

```
Storage Module (низкий уровень)
    ↓ depends on
ViewModels Module (средний уровень)  
    ↓ depends on
ComposeApp Module (высокий уровень)
```

### 2. Инициализация Koin

В главном модуле (например, composeApp) нужно инициализировать Koin в правильном порядке:

```kotlin
// В composeApp/src/commonMain/kotlin
import my.drivebit.shared.storage.di.storageModule
import my.drivebit.viewmodels.di.viewModelsModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(
            // Сначала низкоуровневые модули
            storageModule,
            // Потом высокоуровневые модули
            viewModelsModule,
            // Другие модули...
        )
    }
}
```

### 3. Использование ViewModels

#### В Compose:
```kotlin
@Composable
fun MyScreen() {
    val filtersViewModel: FiltersViewModel = org.koin.compose.koinInject()
    val iconUserViewModel: IconUserViewModel = org.koin.compose.koinInject()
    
    // Использование ViewModels
    val state by filtersViewModel.state.collectAsState()
    val isLoggedIn = iconUserViewModel.isUserLoggedIn()
}
```

#### В обычном коде:
```kotlin
class SomeService {
    private val filtersViewModel: FiltersViewModel by inject()
    private val iconUserViewModel: IconUserViewModel by inject()
    
    fun doSomething() {
        // Использование ViewModels
    }
}
```

### 4. Добавление новых ViewModels

1. Создайте ViewModel класс
2. Добавьте его в `ViewModelsModule.kt`:
```kotlin
factory { 
    YourNewViewModel(
        storage = get(),
        otherDependency = get()
    )
}
```

### 5. Платформо-специфичная инициализация

#### Android (MainActivity.kt):
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        initKoin()
        
        setContent {
            // Ваше приложение
        }
    }
}
```

#### iOS (iOSApp.swift):
```swift
// Инициализация в iOSApp.swift
```

#### Web (index.html):
```javascript
// Инициализация в JS
```

### 6. Тестирование

Для тестов создавайте mock-объекты:

```kotlin
class TestModule : Module {
    override fun onCreate() {
        // Mock модули для тестов
    }
}
```

### 7. Лучшие практики

1. **Порядок модулей важен** - сначала низкоуровневые, потом высокоуровневые
2. **Используйте factory для ViewModels** - они должны пересоздаваться
3. **Используйте single для сервисов** - они должны быть синглтонами
4. **Всегда указывайте типы** в `get<T>()` и `inject<T>()`
5. **Не создавайте циклические зависимости** между модулями
