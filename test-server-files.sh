#!/bin/bash

# Скрипт для проверки доступности файлов на localhost:172.0.0.0
# Проверяет загрузку JS файлов и WASM файлов

# Цвета для вывода
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# URL сервера
SERVER_URL="http://localhost:172.0.0.0"

echo -e "${BLUE}=== Проверка доступности файлов на ${SERVER_URL} ===${NC}"
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

# Счетчики
total_checks=0
passed_checks=0

echo -e "${BLUE}1. Проверка основных файлов:${NC}"

# Проверяем основные файлы
files_to_check=(
    "index.html:Главная страница"
    "composeApp.js:Основной JS файл приложения"
    "skiko.wasm:WASM файл Skiko"
    "skiko.mjs:Модуль Skiko"
    "js-reexport-symbols.mjs:Модуль экспорта символов"
)

for file_info in "${files_to_check[@]}"; do
    IFS=':' read -r file_path description <<< "$file_info"
    total_checks=$((total_checks + 1))
    if check_file "$file_path" "$description"; then
        passed_checks=$((passed_checks + 1))
    fi
done

echo
echo -e "${BLUE}2. Проверка статических ресурсов:${NC}"

# Проверяем статические ресурсы
static_files=(
    "static/images/logos/logo.png:Логотип"
    "static/images/cars/bmw-x5.jpg:Изображение BMW X5"
    "static/images/backgrounds/hero-bg.jpg:Фоновое изображение"
)

for file_info in "${static_files[@]}"; do
    IFS=':' read -r file_path description <<< "$file_info"
    total_checks=$((total_checks + 1))
    if check_file "$file_path" "$description"; then
        passed_checks=$((passed_checks + 1))
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
echo -e "${BLUE}4. Дополнительная диагностика:${NC}"

# Проверяем доступность сервера
echo -n "Проверка доступности сервера: "
if curl -s --connect-timeout 5 "$SERVER_URL" > /dev/null; then
    echo -e "${GREEN}✓ Сервер доступен${NC}"
else
    echo -e "${RED}✗ Сервер недоступен${NC}"
    echo
    echo -e "${YELLOW}Возможные причины:${NC}"
    echo -e "  • Сервер не запущен на порту 172.0.0.0"
    echo -e "  • Неправильный IP адрес или порт"
    echo -e "  • Брандмауэр блокирует подключение"
    echo -e "  • Проблемы с сетью"
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

echo
echo -e "${BLUE}=== ИТОГИ ПРОВЕРКИ ===${NC}"
echo -e "Проведено проверок: ${total_checks}"
echo -e "Успешных: ${GREEN}${passed_checks}${NC}"
echo -e "Неудачных: ${RED}$((total_checks - passed_checks))${NC}"

if [ $passed_checks -eq $total_checks ]; then
    echo -e "${GREEN}✓ Все проверки прошли успешно!${NC}"
    exit 0
elif [ $passed_checks -gt 0 ]; then
    echo -e "${YELLOW}⚠ Некоторые проверки не прошли${NC}"
    exit 1
else
    echo -e "${RED}✗ Все проверки не прошли${NC}"
    exit 1
fi
