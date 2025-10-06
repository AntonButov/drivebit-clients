# Cloud Build Cache Configuration

Этот проект настроен для использования **облачного кеша сборки** между локальной разработкой и GitHub Actions CI/CD.

## ☁️ Что это дает

- **Облачное хранение**: Кеш хранится в GitHub Actions Cache (бесплатно до 10GB)
- **Автоматическая синхронизация**: Кеш автоматически синхронизируется между локальной машиной и CI
- **Ускорение сборки**: Повторные сборки выполняются в 2-5 раз быстрее
- **Экономия времени**: Не нужно пересобирать неизмененные модули
- **Доступность**: Кеш доступен с любой машины, где есть доступ к репозиторию

## ⚙️ Настройка

### 1. Установка GitHub CLI

```bash
# macOS
brew install gh

# Ubuntu/Debian
sudo apt install gh

# Windows
winget install GitHub.cli
```

### 2. Авторизация

```bash
gh auth login
```

### 3. Настройка токена для Gradle

```bash
./sync-cache.sh setup
```

Это создаст переменные окружения для доступа к GitHub Actions Cache.

### 4. Автоматическая настройка

Кеш уже настроен в `gradle.properties`:
```properties
org.gradle.caching=true
org.gradle.cache.push=true
org.gradle.cache.pull=true
```

### 5. GitHub Actions

Кеш автоматически используется в CI/CD через:
- **GitHub Actions Cache** - облачное хранение (до 10GB бесплатно)
- `~/.gradle/build-cache/` - локальный кеш
- `build/` - артефакты сборки
- `~/.gradle/caches/` - зависимости Gradle

## 🛠️ Использование

### Синхронизация кеша

```bash
# Проверить статус кеша
./sync-cache.sh status

# Очистить кеш
./sync-cache.sh clean

# Загрузить кеш из CI (требует GitHub CLI)
./sync-cache.sh download

# Загрузить кеш в CI (требует GitHub CLI)
./sync-cache.sh upload
```

### Локальная сборка с кешем

```bash
# Обычная сборка (использует кеш автоматически)
./gradlew assembleDebug

# Принудительная сборка без кеша
./gradlew assembleDebug --no-build-cache

# Очистка и пересборка
./gradlew clean assembleDebug
```

## 📊 Мониторинг кеша

### Проверка эффективности кеша

```bash
# Запустить сборку с отчетом
./gradlew assembleDebug --build-cache --info | grep -i cache
```

### Статистика кеша

```bash
# Размер кеша
du -sh ~/.gradle/build-cache

# Количество файлов в кеше
find ~/.gradle/build-cache -type f | wc -l
```

## 🔧 Настройка GitHub CLI (опционально)

Для автоматической синхронизации кеша между локальной машиной и CI:

```bash
# Установить GitHub CLI
brew install gh  # macOS
# или
sudo apt install gh  # Ubuntu

# Авторизоваться
gh auth login

# Синхронизировать кеш
./sync-cache.sh upload   # Перед push
./sync-cache.sh download # После pull
```

## 🎯 Рекомендации

### Для разработчиков

1. **Перед push**: Запустите `./sync-cache.sh upload` для передачи кеша в CI
2. **После pull**: Запустите `./sync-cache.sh download` для получения кеша из CI
3. **При проблемах**: Очистите кеш командой `./sync-cache.sh clean`

### Для CI/CD

- Кеш автоматически сохраняется и восстанавливается
- При изменении зависимостей кеш автоматически обновляется
- Кеш очищается при изменении `gradle-wrapper.properties` или `*.gradle*` файлов

## 🐛 Устранение проблем

### Кеш не работает

```bash
# Проверить настройки
./gradlew assembleDebug --info | grep -i cache

# Очистить и пересобрать
./gradlew clean assembleDebug
```

### Большой размер кеша

```bash
# Очистить старый кеш
./sync-cache.sh clean

# Проверить размер
./sync-cache.sh status
```

### Проблемы с синхронизацией

```bash
# Проверить GitHub CLI
gh auth status

# Переавторизоваться
gh auth login
```

## 📈 Ожидаемые результаты

- **Первая сборка**: Обычное время
- **Повторная сборка**: 50-80% ускорение
- **CI сборка**: 30-60% ускорение при наличии кеша
- **Размер кеша**: 100-500MB (зависит от проекта)

## 🔗 Полезные ссылки

- [Gradle Build Cache](https://docs.gradle.org/current/userguide/build_cache.html)
- [GitHub Actions Cache](https://docs.github.com/en/actions/using-workflows/caching-dependencies-to-speed-up-workflows)
- [GitHub CLI](https://cli.github.com/)
