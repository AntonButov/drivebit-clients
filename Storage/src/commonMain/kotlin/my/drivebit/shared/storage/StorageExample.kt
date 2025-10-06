package my.drivebit.shared.storage

/**
 * Пример использования Storage для работы с токеном авторизации
 */
object StorageExample {
    fun demonstrateUsage() {
        // Создаем Storage через фабрику (автоматически создается с диска)
        // val storage = create() // Доступно на всех платформах

        // Пример использования:
        // storage.saveToken("your_auth_token_here")
        //
        // if (storage.isLogined()) {
        //     val token = storage.getToken()
        //     println("User is logged in with token: $token")
        // } else {
        //     println("User is not logged in")
        // }

        // Данные автоматически сохраняются на диск и загружаются при следующем создании Storage
    }
}
