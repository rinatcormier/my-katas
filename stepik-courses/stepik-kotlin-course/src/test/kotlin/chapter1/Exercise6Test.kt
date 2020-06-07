package chapter1

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class Exercise6Test {
    @Test
    fun test() {
        assertTrue { getPattern().isNotEmpty() }
    }
}