package my.drivebit.shared.storage

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class StorageTest {
    @Test
    fun testInitialState() {
        val storage = createTestStorage()

        // Изначально пользователь не авторизован
        assertFalse(storage.isLogined())
        assertNull(storage.getToken())
    }

    @Test
    fun testSaveAndGetToken() {
        val storage = createTestStorage()
        val testToken = "test_token_123"

        // Сохраняем токен
        storage.saveToken(testToken)

        // Проверяем, что токен сохранился
        assertEquals(testToken, storage.getToken())
        assertTrue(storage.isLogined())
    }

    @Test
    fun testSaveEmptyToken() {
        val storage = createTestStorage()

        // Сохраняем пустой токен
        storage.saveToken("")

        // Пустой токен означает, что пользователь не авторизован
        assertEquals("", storage.getToken())
        assertFalse(storage.isLogined())
    }

    @Test
    fun testSaveNullToken() {
        val storage = createTestStorage()

        // Сохраняем null токен (если поддерживается)
        storage.saveToken("")

        // Null токен означает, что пользователь не авторизован
        assertFalse(storage.isLogined())
    }

    @Test
    fun testTokenReplacement() {
        val storage = createTestStorage()

        // Сохраняем первый токен
        val firstToken = "first_token"
        storage.saveToken(firstToken)
        assertEquals(firstToken, storage.getToken())
        assertTrue(storage.isLogined())

        // Заменяем на второй токен
        val secondToken = "second_token"
        storage.saveToken(secondToken)
        assertEquals(secondToken, storage.getToken())
        assertTrue(storage.isLogined())
    }

    @Test
    fun testMultipleOperations() {
        val storage = createTestStorage()

        // Проверяем последовательность операций
        assertFalse(storage.isLogined())

        storage.saveToken("token1")
        assertTrue(storage.isLogined())
        assertEquals("token1", storage.getToken())

        storage.saveToken("token2")
        assertTrue(storage.isLogined())
        assertEquals("token2", storage.getToken())

        storage.saveToken("")
        assertFalse(storage.isLogined())
        assertEquals("", storage.getToken())
    }

    // Фабричный метод для создания тестового хранилища
    private fun createTestStorage(): Storage {
        // Используем тестовую реализацию для unit-тестов
        return TestStorage()
    }
}

/**
 * Тестовая реализация Storage для unit-тестов
 */
private class TestStorage : Storage {
    private var token: String? = null

    override fun isLogined(): Boolean {
        return !token.isNullOrEmpty()
    }

    override fun saveToken(token: String) {
        this.token = token
    }

    override fun getToken(): String? {
        return token
    }
}
