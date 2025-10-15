#!/bin/bash

# Гибкий скрипт для проверки доступности файлов на различных серверах
# Использование: ./test-server-files-flexible.sh [URL]
# Примеры:
#   ./test-server-files-flexible.sh http://localhost:8080
#   ./test-server-files-flexible.sh http://localhost:172.0.0.0
#   ./test-server-files-flexible.sh http://127.0.0.1:3000

# Цвета для вывода
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

# URL сервера (по умолчанию localhost:172.0.0.0)
DEFAULT_SERVER="http://localhost:172.0.0.0"
SERVER_URL="${1:-$DEFAULT_SERVER}"

echo -e "${CYAN}=== Проверка доступности файлов на ${SERVER_URL} ===${NC}"
echo

# Функция для проверки файла
check_file() {
    local file_path="$1"
    local description="$2"
    local full_url="${SERVER_URL}/${file_path}"
    
    echo -n "Проверка ${description} (${file_path}): "
    
    # Используем curl для проверки
    response=$(curl -s -o /dev/null -w "%{http_code}" "$full_url" --connect-timeout 5)
    
    if [ "$response" = "200" ]; then
        echo -e "${GREEN}✓ OK (HTTP $response)${NC}"
        
        # Дополнительно проверяем размер файла
        content_length=$(curl -s -I "$full_url" | grep -i "content-length" | cut -d' ' -f2 | tr -d '\r\n')
        if [ ! -z "$content_length" ] && [ "$content_length" != "0" ]; then
            echo -e "  ${BLUE}  Размер: ${content_length} байт${NC}"
        fi
        
        return 0
    elif [ "$response" = "000" ]; then
        echo -e "${RED}✗ ОШИБКА: Не удалось подключиться к серверу${NC}"
        return 1
    else
        echo -e "${RED}✗ ОШИБКА: HTTP $response${NC}"
        return 1
    fi
}

# Функция для проверки содержимого файла
check_file_content() {
    local file_path="$1"
    local expected_content="$2"
    local description="$3"
    local full_url="${SERVER_URL}/${file_path}"
    
    echo -n "Проверка содержимого ${description}: "
    
    # Получаем первые несколько байт файла
    content=$(curl -s --connect-timeout 5 "$full_url" | head -c 100)
    
    if [[ "$content" == *"$expected_content"* ]]; then
        echo -e "${GREEN}✓ OK - содержимое корректно${NC}"
        return 0
    else
        echo -e "${YELLOW}⚠ ПРЕДУПРЕЖДЕНИЕ: содержимое не соответствует ожидаемому${NC}"
        echo -e "  ${BLUE}  Получено: ${content:0:50}...${NC}"
        return 1
    fi
}

# Функция для проверки типа файла
check_file_type() {
    local file_path="$1"
    local expected_type="$2"
    local description="$3"
    local full_url="${SERVER_URL}/${file_path}"
    
    echo -n "Проверка типа файла ${description}: "
    
    content_type=$(curl -s -I "$full_url" --connect-timeout 5 | grep -i "content-type" | cut -d' ' -f2- | tr -d '\r\n')
    
    if [[ "$content_type" == *"$expected_type"* ]]; then
        echo -e "${GREEN}✓ OK - Content-Type: ${content_type}${NC}"
        return 0
    else
        echo -e "${YELLOW}⚠ ПРЕДУПРЕЖДЕНИЕ: неожиданный Content-Type: ${content_type}${NC}"
        return 1
    fi
}

# Счетчики
total_checks=0
passed_checks=0

echo -e "${BLUE}1. Проверка основных файлов:${NC}"

# Проверяем основные файлы
files_to_check=(
    "index.html:Главная страница:text/html"
    "composeApp.js:Основной JS файл приложения:application/javascript"
    "skiko.wasm:WASM файл Skiko:application/wasm"
    "skiko.mjs:Модуль Skiko:text/javascript"
    "js-reexport-symbols.mjs:Модуль экспорта символов:text/javascript"
)

for file_info in "${files_to_check[@]}"; do
    IFS=':' read -r file_path description content_type <<< "$file_info"
    
    # Проверка доступности
    total_checks=$((total_checks + 1))
    if check_file "$file_path" "$description"; then
        passed_checks=$((passed_checks + 1))
        
        # Проверка типа файла
        total_checks=$((total_checks + 1))
        if check_file_type "$file_path" "$content_type" "$description"; then
            passed_checks=$((passed_checks + 1))
        fi
    fi
done

echo
echo -e "${BLUE}2. Проверка статических ресурсов:${NC}"

# Проверяем статические ресурсы
static_files=(
    "static/images/logos/logo.png:Логотип:image/png"
    "static/images/cars/bmw-x5.jpg:Изображение BMW X5:image/jpeg"
    "static/images/backgrounds/hero-bg.jpg:Фоновое изображение:image/jpeg"
)

for file_info in "${static_files[@]}"; do
    IFS=':' read -r file_path description content_type <<< "$file_info"
    
    total_checks=$((total_checks + 1))
    if check_file "$file_path" "$description"; then
        passed_checks=$((passed_checks + 1))
        
        # Проверка типа файла
        total_checks=$((total_checks + 1))
        if check_file_type "$file_path" "$content_type" "$description"; then
            passed_checks=$((passed_checks + 1))
        fi
    fi
done

echo
echo -e "${BLUE}3. Проверка содержимого файлов:${NC}"

# Проверяем содержимое ключевых файлов
total_checks=$((total_checks + 1))
if check_file_content "index.html" "<!DOCTYPE html" "HTML структура"; then
    passed_checks=$((passed_checks + 1))
fi

total_checks=$((total_checks + 1))
if check_file_content "composeApp.js" "function" "JavaScript код"; then
    passed_checks=$((passed_checks + 1))
fi

echo
echo -e "${BLUE}4. Специальная проверка WASM файлов:${NC}"

# Специальная проверка для WASM файлов
total_checks=$((total_checks + 1))
echo -n "Проверка WASM магических байтов: "
wasm_content=$(curl -s --connect-timeout 5 "${SERVER_URL}/skiko.wasm" | head -c 4 | hexdump -C | head -1)
if [[ "$wasm_content" == *"00 61 73 6d"* ]] || [[ "$wasm_content" == *"6d 73 61 00"* ]]; then
    echo -e "${GREEN}✓ OK - корректные WASM магические байты${NC}"
    passed_checks=$((passed_checks + 1))
else
    echo -e "${RED}✗ ОШИБКА: некорректные WASM магические байты${NC}"
fi

echo
echo -e "${BLUE}5. Дополнительная диагностика:${NC}"

# Проверяем доступность сервера
echo -n "Проверка доступности сервера: "
if curl -s --connect-timeout 5 "$SERVER_URL" > /dev/null; then
    echo -e "${GREEN}✓ Сервер доступен${NC}"
else
    echo -e "${RED}✗ Сервер недоступен${NC}"
    echo
    echo -e "${YELLOW}Возможные причины:${NC}"
    echo -e "  • Сервер не запущен на указанном адресе"
    echo -e "  • Неправильный IP адрес или порт"
    echo -e "  • Брандмауэр блокирует подключение"
    echo -e "  • Проблемы с сетью"
    echo
    echo -e "${CYAN}Попробуйте запустить сервер командой:${NC}"
    echo -e "  ${BLUE}./gradlew :composeApp:wasmJsBrowserDevelopmentRun${NC}"
    echo -e "  ${BLUE}или${NC}"
    echo -e "  ${BLUE}python -m http.server 8080${NC}"
    echo -e "  ${BLUE}или${NC}"
    echo -e "  ${BLUE}npx serve . -p 3000${NC}"
    exit 1
fi

# Проверяем заголовки сервера
echo -n "Проверка заголовков сервера: "
headers=$(curl -s -I "$SERVER_URL" --connect-timeout 5)
if echo "$headers" | grep -i "content-type" > /dev/null; then
    content_type=$(echo "$headers" | grep -i "content-type" | cut -d' ' -f2- | tr -d '\r\n')
    echo -e "${GREEN}✓ Content-Type: ${content_type}${NC}"
else
    echo -e "${YELLOW}⚠ Заголовки Content-Type не найдены${NC}"
fi

# Проверяем поддержку CORS
echo -n "Проверка CORS заголовков: "
cors_headers=$(echo "$headers" | grep -i "access-control")
if [ ! -z "$cors_headers" ]; then
    echo -e "${GREEN}✓ CORS заголовки найдены${NC}"
else
    echo -e "${YELLOW}⚠ CORS заголовки не найдены${NC}"
fi

echo
echo -e "${BLUE}=== ИТОГИ ПРОВЕРКИ ===${NC}"
echo -e "Сервер: ${CYAN}${SERVER_URL}${NC}"
echo -e "Проведено проверок: ${total_checks}"
echo -e "Успешных: ${GREEN}${passed_checks}${NC}"
echo -e "Неудачных: ${RED}$((total_checks - passed_checks))${NC}"

if [ $passed_checks -eq $total_checks ]; then
    echo -e "${GREEN}✓ Все проверки прошли успешно!${NC}"
    echo -e "${CYAN}Все файлы доступны и загружаются корректно.${NC}"
    exit 0
elif [ $passed_checks -gt $((total_checks / 2)) ]; then
    echo -e "${YELLOW}⚠ Большинство проверок прошли успешно${NC}"
    echo -e "${YELLOW}Возможно, есть проблемы с некоторыми файлами.${NC}"
    exit 1
else
    echo -e "${RED}✗ Многие проверки не прошли${NC}"
    echo -e "${RED}Сервер недоступен или файлы не найдены.${NC}"
    exit 1
fi
