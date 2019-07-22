package org.stepik.course187.ch6_3ex1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.stepik.course187.ch6_3ex1.Main.ternaryOperator;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

class MainTest {
    @Test
    void test() {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        assertThat(safeStringLength.apply("hello")).isEqualTo(5);
        assertThat(safeStringLength.apply(null)).isEqualTo(0);
    }
}