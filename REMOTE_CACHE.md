# Remote Build Cache Setup

Проект настроен для использования удаленного HTTP кеша сборки.

## 🚀 Быстрый старт

### 1. Настройка сервера кеша

У вас есть несколько вариантов:

#### Вариант A: Использовать существующий сервер

Если у вас есть HTTP сервер для кеша:

```bash
# Добавьте в ~/.zshrc или ~/.bashrc
export GRADLE_CACHE_URL="https://your-cache-server.com/cache/"
export GRADLE_CACHE_PUSH="true"
export GRADLE_CACHE_USERNAME="your-username"  # опционально
export GRADLE_CACHE_PASSWORD="your-password"  # опционально
```

#### Вариант B: Поднять свой сервер на Digital Ocean

```bash
# На вашем сервере (143.198.69.242)
ssh root@143.198.69.242

# Установите Gradle Build Cache Node
docker run -d \
  -p 5071:5071 \
  -v gradle-build-cache:/data \
  --name gradle-cache \
  gradle/build-cache-node:latest

# Настройте nginx проксирование
# Добавьте в /etc/nginx/sites-available/gradle-cache:
server {
    listen 80;
    server_name cache.drivebit.com;  # или ваш домен
    
    location / {
        proxy_pass http://localhost:5071;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

Затем локально:
```bash
export GRADLE_CACHE_URL="http://143.198.69.242:5071/cache/"
export GRADLE_CACHE_PUSH="true"
```

#### Вариант C: Использовать Gradle Enterprise (бесплатный tier)

1. Зарегистрируйтесь на https://gradle.com
2. Получите URL кеша
3. Настройте переменные окружения

### 2. Для GitHub Actions

Добавьте в GitHub Secrets:
- `GRADLE_CACHE_URL`: URL вашего кеш-сервера
- `GRADLE_CACHE_PUSH`: `true`
- `GRADLE_CACHE_USERNAME`: username (если нужно)
- `GRADLE_CACHE_PASSWORD`: password (если нужно)

Обновите `.github/workflows/test.yml`:
```yaml
- name: Build with cache
  env:
    GRADLE_CACHE_URL: ${{ secrets.GRADLE_CACHE_URL }}
    GRADLE_CACHE_PUSH: true
  run: ./gradlew assembleDebug
```

## 📊 Проверка работы кеша

```bash
# Первая сборка (создает кеш)
./gradlew clean assembleDebug --build-cache

# Вторая сборка (использует кеш)
./gradlew clean assembleDebug --build-cache

# Вы должны увидеть:
# FROM-CACHE вместо EXECUTED
```

## 🔧 Временное отключение кеша

```bash
# Отключить удаленный кеш
unset GRADLE_CACHE_URL

# Или собрать без кеша
./gradlew assembleDebug --no-build-cache
```

## 💡 Рекомендации

1. **Для команды**: Используйте общий сервер кеша
2. **Для CI/CD**: Включите `GRADLE_CACHE_PUSH=true`
3. **Безопасность**: Используйте HTTPS и аутентификацию для продакшена

## 🎯 Преимущества

- ✅ **Простая настройка**: Всего 3 переменных окружения
- ✅ **Гибкость**: Можно использовать любой HTTP сервер
- ✅ **Безопасность**: Поддержка аутентификации
- ✅ **Скорость**: Сборка ускоряется в 2-5 раз
- ✅ **Совместимость**: Работает локально и в CI/CD

## 🐛 Проблемы?

```bash
# Проверить подключение к серверу
curl $GRADLE_CACHE_URL

# Проверить настройки Gradle
./gradlew --build-cache --info | grep -i cache

# Посмотреть статистику кеша
./gradlew assembleDebug --build-cache --scan
```

