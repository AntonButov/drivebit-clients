#!/bin/bash

# Интеграционный тест для проверки веб-приложения
# Проверяет, что:
# 1. Веб-сервер запускается
# 2. Приложение загружается
# 3. НЕТ файлов с расширением .wasm

set -e

echo "🚀 Запуск интеграционного теста для веб-приложения..."

# Функция для очистки процессов
cleanup() {
    echo "🧹 Очистка процессов..."
    if [ ! -z "$SERVER_PID" ]; then
        kill $SERVER_PID 2>/dev/null || true
    fi
    pkill -f "jsBrowserDevelopmentRun" 2>/dev/null || true
    pkill -f "gradle" 2>/dev/null || true
}

# Устанавливаем trap для очистки при выходе
trap cleanup EXIT

# Запускаем веб-сервер в фоне
echo "📡 Запуск веб-сервера..."
./gradlew :composeApp:jsBrowserDevelopmentRun --no-daemon &
SERVER_PID=$!

# Ждем запуска сервера (максимум 60 секунд)
echo "⏳ Ожидание запуска сервера..."
for i in {1..60}; do
    if curl -s http://localhost:8080 > /dev/null 2>&1; then
        echo "✅ Сервер запущен на http://localhost:8080"
        break
    fi
    if [ $i -eq 60 ]; then
        echo "❌ Сервер не запустился за 60 секунд"
        exit 1
    fi
    sleep 1
done

# Проверяем, что главная страница загружается
echo "🌐 Проверка загрузки главной страницы..."
if ! curl -s http://localhost:8080 | grep -q "html\|body"; then
    echo "❌ Главная страница не загружается корректно"
    exit 1
fi
echo "✅ Главная страница загружается"

# Проверяем отсутствие WASM файлов
echo "🔍 Проверка отсутствия WASM файлов..."
WASM_FILES=$(curl -s http://localhost:8080 | grep -o '[^"]*\.wasm[^"]*' || true)

if [ ! -z "$WASM_FILES" ]; then
    echo "❌ НАЙДЕНЫ WASM ФАЙЛЫ:"
    echo "$WASM_FILES"
    echo "❌ Веб-приложение не должно использовать WASM!"
    exit 1
else
    echo "✅ WASM файлы не найдены - это правильно для JS таргета"
fi

# Проверяем, что есть JS файлы (это правильно)
echo "🔍 Проверка наличия JS файлов..."
JS_FILES=$(curl -s http://localhost:8080 | grep -o '[^"]*\.js[^"]*' || true)

if [ -z "$JS_FILES" ]; then
    echo "❌ JS файлы не найдены - это странно для веб-приложения"
    exit 1
else
    echo "✅ JS файлы найдены:"
    echo "$JS_FILES"
fi

# Проверяем Network запросы через curl для дополнительной проверки
echo "🔍 Дополнительная проверка через Network запросы..."
MAIN_JS=$(curl -s http://localhost:8080 | grep -o 'composeApp\.js' | head -1)
if [ ! -z "$MAIN_JS" ]; then
    echo "📄 Проверяем основной JS файл: $MAIN_JS"
    if curl -s "http://localhost:8080/$MAIN_JS" | grep -q "\.wasm"; then
        echo "❌ Основной JS файл содержит ссылки на WASM файлы!"
        exit 1
    else
        echo "✅ Основной JS файл не содержит ссылок на WASM"
    fi
fi

echo "🎉 Интеграционный тест прошел успешно!"
echo "✅ Веб-приложение работает корректно без WASM файлов"
