# GitHub Pages Setup

Этот документ описывает настройку автоматического деплоя проекта на GitHub Pages.

## Настройка GitHub Pages

### 1. Включение GitHub Pages в репозитории

1. Перейдите в настройки репозитория на GitHub
2. В меню слева выберите **Pages**
3. В разделе **Source** выберите:
   - Source: **GitHub Actions**
4. Нажмите **Save**

### 2. Автоматический деплой

Деплой происходит автоматически при:
- Push в ветки `trunk`, `main` или `master`
- Ручном запуске workflow через вкладку **Actions**

### 3. Структура деплоя

Workflow `.github/workflows/github-pages.yml` выполняет:

1. **Сборка JS приложения**
   - Компилирует Kotlin/JS код
   - Создает production build

2. **Подготовка контента**
   - Копирует собранные файлы
   - Добавляет кастомный `index.html`
   - Копирует статические ресурсы (изображения)
   - Добавляет cache-busting версии для JS файлов

3. **Деплой на GitHub Pages**
   - Загружает артефакты
   - Публикует на GitHub Pages

## Доступ к сайту

После успешного деплоя сайт будет доступен по адресу:
```
https://<username>.github.io/<repository-name>/
```

Для кастомного домена:
1. Добавьте CNAME файл в корень проекта
2. Настройте DNS записи у вашего провайдера

## Локальная проверка

Для локальной проверки перед деплоем:

```bash
# Сборка production версии
./gradlew :composeApp:jsBrowserDistribution

# Запуск локального сервера
cd composeApp/build/dist/js/productionExecutable
python3 -m http.server 8080
```

Затем откройте http://localhost:8080 в браузере.

## Troubleshooting

### Ошибка 404 на GitHub Pages

- Убедитесь, что файл `.nojekyll` присутствует в корне
- Проверьте, что в настройках Pages выбран источник **GitHub Actions**

### Старая версия кэшируется

- Workflow автоматически добавляет timestamp для cache-busting
- Если нужно, сделайте hard refresh (Ctrl+Shift+R / Cmd+Shift+R)

### JS файлы не загружаются

- Проверьте пути к скриптам в `index.html`
- Убедитесь, что все необходимые файлы копируются в `pages_build`

## Дополнительные ресурсы

- [GitHub Pages Documentation](https://docs.github.com/en/pages)
- [GitHub Actions for Pages](https://github.com/actions/deploy-pages)

