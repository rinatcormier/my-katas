package chapter1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercise3Test {
    @Test
    fun test() {
        assertEquals("[a, b, c]", joinOptions(listOf("a", "b", "c")))
    }
}