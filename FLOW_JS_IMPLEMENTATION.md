# Flow Implementation for JS Target

В проекте DriveBit реализована поддержка Flow для JS платформы через StateScreenModel из Voyager.

## Архитектура Flow на JS

### 1. StateScreenModel
Базовый класс для ViewModel с встроенной поддержкой Flow:

```kotlin
class SplashViewModel : StateScreenModel<SplashState>(SplashState.Init) {
    init {
        screenModelScope.launch {
            delay(2000)
            mutableState.value = SplashState.Loaded
        }
    }
}
```

### 2. Flow Properties
- **mutableState**: `MutableStateFlow<T>` - для изменения состояния
- **state**: `StateFlow<T>` - для чтения состояния
- **screenModelScope**: `CoroutineScope` - для запуска корутин

### 3. Использование в Compose
```kotlin
@Composable
override fun Content() {
    val viewModel: SplashViewModel = koinScreenModel()
    val state = viewModel.state.collectAsState().value
    
    when (state) {
        SplashState.Init -> LoaderScreen()
        SplashState.Loaded -> MainScreenLoaded()
    }
}
```

## Особенности JS реализации

### 1. Отсутствие Compose на JS
JS версия НЕ использует Compose, вместо этого:
- Используется `kotlinx-html` для рендеринга
- Flow подписывается через `collect()` в корутинах
- HTML обновляется напрямую через DOM API

### 2. Flow с kotlinx-html
```kotlin
// Подписка на Flow с обновлением HTML
fun subscribeToFlow(flow: Flow<String>, elementId: String) {
    scope.launch {
        flow.collect { value ->
            updateHtmlElement(elementId, value)
        }
    }
}
```

### 3. ViewModel без StateScreenModel
Для JS версии используется обычный класс с Flow:
```kotlin
class FlowViewModel {
    private val _appState = MutableStateFlow(AppState.Init)
    val appState: StateFlow<AppState> = _appState.asStateFlow()
    
    fun loadData() {
        scope.launch {
            _appState.value = AppState.Loading
            // ... логика
        }
    }
}

## Примеры использования

### Базовый ViewModel с Flow
```kotlin
class MyViewModel : StateScreenModel<MyState>(MyState.Init) {
    fun loadData() {
        screenModelScope.launch {
            mutableState.value = MyState.Loading
            try {
                val data = apiService.getData()
                mutableState.value = MyState.Loaded(data)
            } catch (e: Exception) {
                mutableState.value = MyState.Error(e.message)
            }
        }
    }
}
```

### Использование в Screen
```kotlin
class MyScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MyViewModel>()
        val state by viewModel.state.collectAsState()
        
        when (state) {
            is MyState.Loading -> LoadingIndicator()
            is MyState.Loaded -> DataContent(state.data)
            is MyState.Error -> ErrorMessage(state.message)
        }
    }
}
```

## Преимущества

- ✅ **Кроссплатформенность** - Flow работает на всех платформах
- ✅ **Простота использования** - StateScreenModel упрощает работу с состоянием
- ✅ **Автоматическое управление жизненным циклом** - через Voyager
- ✅ **Reactive UI** - автоматическое обновление UI при изменении состояния

## Ограничения JS версии

- ❌ **Нет Koin** - используется ручная DI
- ❌ **Нет полного Compose** - используется SimpleWebApp
- ❌ **Ограниченная навигация** - упрощенная веб-версия

## Примеры реализации

### 1. Базовый Flow с kotlinx-html
```kotlin
// FlowExample.kt
fun simpleFlow(): Flow<String> = flow {
    emit("Hello")
    delay(1000)
    emit("World")
}

// Подписка на Flow
fun subscribeToFlow(flow: Flow<String>, elementId: String) {
    scope.launch {
        flow.collect { value ->
            updateHtmlElement(elementId, value)
        }
    }
}
```

### 2. ViewModel с Flow (без Compose)
```kotlin
// FlowViewModel.kt
class FlowViewModel {
    private val _appState = MutableStateFlow(AppState.Init)
    val appState: StateFlow<AppState> = _appState.asStateFlow()
    
    fun loadData() {
        scope.launch {
            _appState.value = AppState.Loading
            // ... логика загрузки
        }
    }
}
```

### 3. HTML рендерер с Flow
```kotlin
// FlowHtmlRenderer.kt
class FlowHtmlRenderer {
    fun subscribeToAppState(viewModel: FlowViewModel, containerId: String) {
        scope.launch {
            viewModel.appState.collect { state ->
                updateAppStateHtml(containerId, state)
            }
        }
    }
    
    private fun updateAppStateHtml(containerId: String, state: AppState) {
        val html = when (state) {
            is AppState.Loading -> "<div class='loading'>Loading...</div>"
            is AppState.Loaded -> "<div class='loaded'>✅ Data loaded</div>"
            // ...
        }
        updateHtmlElement(containerId, html)
    }
}
```

### 4. Полный пример с HTML
```kotlin
// Создание HTML с подпиской на Flow
fun createFlowDemo() {
    val viewModel = FlowViewModel()
    val renderer = FlowHtmlRenderer()
    
    // Создаем HTML структуру
    document.body?.innerHTML = """
        <div id="flow-demo">
            <h1>Flow Demo</h1>
            <button id="load-data">Load Data</button>
            <div id="app-state"></div>
            <div id="data-container"></div>
        </div>
    """
    
    // Подписываемся на Flow
    renderer.subscribeToAppState(viewModel, "app-state")
    renderer.subscribeToData(viewModel, "data-container")
    
    // Подписываемся на кнопки
    document.getElementById("load-data")?.addEventListener("click") {
        viewModel.loadData()
    }
}
```

## Заключение

Flow в JS версии работает БЕЗ Compose через kotlinx-html, обеспечивая реактивное управление состоянием с прямым обновлением DOM. Это позволяет использовать Flow на всех платформах проекта с разными подходами к UI.

### Ключевые файлы:
- `FLOW_JS_IMPLEMENTATION.md` - документация по Flow
- `FlowExample.kt` - примеры использования Flow с kotlinx-html
- `FlowViewModel.kt` - ViewModel с Flow (без Compose)
- `FlowHtmlRenderer.kt` - HTML рендерер с Flow

### Преимущества подхода:
- ✅ **Flow работает** - полная поддержка Flow на JS
- ✅ **Нет Compose** - использует kotlinx-html
- ✅ **Реактивное UI** - автоматическое обновление HTML
- ✅ **Простота** - прямое обновление DOM
- ✅ **Производительность** - минимальные зависимости
