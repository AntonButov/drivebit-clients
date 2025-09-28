# Подписка на Flow в JS - Рабочие примеры

## ✅ Да, подписаться на Flow в JS МОЖНО!

Вот рабочие примеры того, как подписываться на Flow в JS версии проекта.

## 🚀 Простые примеры

### 1. Базовый Flow

```kotlin
// Создание Flow
fun createSimpleFlow(): Flow<String> = flow {
    emit("Привет")
    delay(1000)
    emit("из")
    delay(1000)
    emit("Flow!")
}

// Подписка на Flow
fun subscribeToFlow(flow: Flow<String>, elementId: String) {
    scope.launch {
        flow.collect { value ->
            // Обновляем HTML элемент
            val element = document.getElementById(elementId)
            element?.innerHTML = "<p>$value</p>"
        }
    }
}
```

### 2. StateFlow

```kotlin
// Создание StateFlow
private val _counter = MutableStateFlow(0)
val counter: StateFlow<Int> = _counter.asStateFlow()

// Подписка на StateFlow
fun subscribeToCounter(elementId: String) {
    scope.launch {
        counter.collect { value ->
            val element = document.getElementById(elementId)
            element?.innerHTML = "<h2>Счетчик: $value</h2>"
        }
    }
}
```

## 📁 Созданные файлы

### 1. `SimpleFlowExample.kt`
- Простой Flow с задержками
- Подписка с обновлением HTML
- Интерактивная кнопка

### 2. `StateFlowExample.kt`
- StateFlow для состояния приложения
- Подписка на изменения счетчика
- Подписка на состояние загрузки

## 🔧 Как использовать

### Запуск простого Flow демо:
```kotlin
// В консоли браузера или в коде
startFlowDemo()
```

### Запуск StateFlow демо:
```kotlin
// В консоли браузера или в коде
startStateFlowDemo()
```

## 💡 Ключевые моменты

1. **MainScope** - для запуска корутин в JS
2. **collect()** - для подписки на Flow
3. **document.getElementById()** - для обновления HTML
4. **addEventListener()** - для обработки событий

## 🎯 Результат

- ✅ **Flow работает** - полная поддержка
- ✅ **StateFlow работает** - реактивные состояния
- ✅ **Подписка работает** - автоматическое обновление UI
- ✅ **HTML обновляется** - прямая работа с DOM

## 📋 Примеры использования

### Простой Flow:
```kotlin
val example = SimpleFlowExample()
example.subscribeToFlow(example.createSimpleFlow(), "my-element")
```

### StateFlow:
```kotlin
val example = StateFlowExample()
example.subscribeToCounter("counter-display")
example.incrementCounter() // UI обновится автоматически
```

## 🚀 Заключение

**Да, подписаться на Flow в JS МОЖНО!** 

Flow и StateFlow полностью поддерживаются в JS версии проекта. Вы можете:
- Создавать Flow
- Подписываться на Flow через `collect()`
- Обновлять HTML при изменении Flow
- Использовать StateFlow для реактивных состояний

Все работает через kotlinx-coroutines и kotlinx-html!
