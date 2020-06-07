package chapter1

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Exercise5Test {
    @Test
    fun test() {
        assertTrue { containsEven(listOf(1, 2, 3)) }
        assertFalse { containsEven(listOf(1, 3, 5)) }
    }
}