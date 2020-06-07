package chapter1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Exercise4Test {
    @Test
    fun test() {
        assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }
}