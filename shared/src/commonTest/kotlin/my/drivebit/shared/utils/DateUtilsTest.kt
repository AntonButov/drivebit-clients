package my.drivebit.shared.utils

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DateUtilsTest {
    @Test
    fun testGetCurrentDateTime() {
        val dateTime = DateUtils.getCurrentDateTime()
        assertNotNull(dateTime)
    }

    @Test
    fun testGetCurrentTimestamp() {
        val timestamp = DateUtils.getCurrentTimestamp()
        assertTrue(timestamp > 0)
    }

    @Test
    fun testFormatDate() {
        val dateTime = DateUtils.getCurrentDateTime()
        val formatted = DateUtils.formatDate(dateTime)
        assertTrue(formatted.contains("."))
    }
}
