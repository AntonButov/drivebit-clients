# Примеры использования CommonViewModels с Koin

## 1. В Mobile модуле

### Добавление в build.gradle.kts:
```kotlin
dependencies {
    implementation(project(":CommonViewModels"))
    implementation(project(":Storage"))
}
```

### Использование в Screen:
```kotlin
@Composable
fun FiltersScreen() {
    val filtersViewModel: FiltersViewModel = koinInject()
    val state by filtersViewModel.state.collectAsState()
    
    LazyColumn {
        items(state.filters) { filter ->
            FilterItem(
                filter = filter,
                isSelected = filter.title == state.selected,
                onClick = { filtersViewModel.onSelect(filter.title) }
            )
        }
    }
}
```

## 2. В Auth модуле

### Использование IconUserViewModel:
```kotlin
class AuthRepository(
    private val userViewModel: IconUserViewModel
) {
    suspend fun login(email: String, password: String): Boolean {
        // Логика авторизации
        val token = "received_token_from_api"
        
        // Сохраняем токен
        userViewModel.saveUserToken(token)
        
        return true
    }
    
    fun isUserLoggedIn(): Boolean {
        return userViewModel.isUserLoggedIn()
    }
}
```

## 3. В UI-Components модуле

### Компонент с ViewModel:
```kotlin
@Composable
fun UserProfileComponent() {
    val userViewModel: IconUserViewModel = koinInject()
    val isLoggedIn = userViewModel.isUserLoggedIn()
    
    if (isLoggedIn) {
        UserLoggedInView()
    } else {
        UserLoginButton()
    }
}
```

## 4. Создание новых ViewModels

### 1. Создайте ViewModel:
```kotlin
class SearchViewModel(
    private val storage: Storage
) {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()
    
    fun updateQuery(query: String) {
        _searchQuery.value = query
        // Сохраняем в storage
        storage.saveToken("search_query:$query")
    }
}
```

### 2. Добавьте в ViewModelsModule:
```kotlin
val viewModelsModule: Module = module {
    factory { 
        SearchViewModel(
            storage = get()
        )
    }
}
```

### 3. Используйте в UI:
```kotlin
@Composable
fun SearchScreen() {
    val searchViewModel: SearchViewModel = koinInject()
    val query by searchViewModel.searchQuery.collectAsState()
    
    SearchField(
        value = query,
        onValueChange = searchViewModel::updateQuery
    )
}
```

## 5. Тестирование

### Mock модуль для тестов:
```kotlin
val testViewModelsModule = module {
    factory<FiltersViewModel> { 
        FiltersViewModel(
            storage = get()
        )
    }
}

class FiltersViewModelTest {
    @BeforeTest
    fun setup() {
        startKoin {
            modules(
                mockStorageModule,
                testViewModelsModule
            )
        }
    }
    
    @AfterTest
    fun tearDown() {
        stopKoin()
    }
}
```

## 6. Лучшие практики

1. **Всегда используйте `factory` для ViewModels** - они должны создаваться заново
2. **Используйте `single` для сервисов** - они должны быть синглтонами  
3. **Правильный порядок модулей**:
   ```kotlin
   modules(
       storageModule,        // Низкий уровень
       viewModelsModule,     // Средний уровень  
       appModule            // Высокий уровень
   )
   ```
4. **Типизация важна**:
   ```kotlin
   val viewModel: FiltersViewModel = koinInject() // ✅ Правильно
   val viewModel = koinInject<FiltersViewModel>() // ✅ Тоже правильно
   val viewModel = koinInject() // ❌ Неправильно - нет типизации
   ```
