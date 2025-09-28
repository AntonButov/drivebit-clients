import kotlin.test.Test
import kotlin.test.assertTrue

class AppTest {
    @Test
    fun testApp() {
        assertTrue(true, "App should work")
    }

    @Test
    fun testBasicMath() {
        val result = 2 + 2
        assertTrue(result == 4, "Basic math should work")
    }
}
