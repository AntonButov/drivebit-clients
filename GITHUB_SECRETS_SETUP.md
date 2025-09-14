# GitHub Secrets Setup

Для настройки автоматического деплоя нужно добавить следующие secrets в настройках репозитория:

## Как добавить secrets:

1. Перейдите в ваш репозиторий на GitHub
2. Нажмите на вкладку "Settings"
3. В левом меню выберите "Secrets and variables" → "Actions"
4. Нажмите "New repository secret"
5. Добавьте каждый secret:

## Необходимые Secrets:

### SERVER_HOST
```
143.198.69.242
```

### SERVER_USER
```
root
```

### SERVER_SSH_KEY
```
-----BEGIN OPENSSH PRIVATE KEY-----
[Содержимое приватного ключа из ~/.ssh/github_actions_deploy]
-----END OPENSSH PRIVATE KEY-----
```

### SERVER_PORT (опционально)
```
22
```

### SERVER_DOMAIN (опционально)
```
your-domain.com
```

## Как получить приватный ключ:

Выполните команду на вашем локальном компьютере:
```bash
cat ~/.ssh/github_actions_deploy
```

Скопируйте весь вывод (включая строки с -----BEGIN и -----END) и вставьте в SERVER_SSH_KEY.

## Проверка:

После добавления всех secrets:
1. Создайте pull request
2. После мержа в trunk должен запуститься workflow деплоя
3. Приложение будет доступно по адресу: http://143.198.69.242:3000

## Текущий статус сервера:

✅ Python веб-сервер настроен и работает на порту 3000
✅ SSH ключи настроены
✅ Директория /var/www/drivebit-clients готова
✅ Systemd сервис настроен для автозапуска
