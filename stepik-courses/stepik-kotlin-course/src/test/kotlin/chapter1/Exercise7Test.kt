package chapter1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Exercise7Test {
    @Test
    fun test() {
        Assertions.assertThat(getPeople()).containsExactly(Person("Alice", 29), Person("Bob", 31))
    }
}