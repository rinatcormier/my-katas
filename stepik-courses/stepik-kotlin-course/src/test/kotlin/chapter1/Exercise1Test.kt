package chapter1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercise1Test {
    @Test
    fun test() {
        assertEquals(Exercise1().start(), "OK")
    }
}