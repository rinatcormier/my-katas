package org.stepik.course187.ch6_1ex1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PairTest {

    @Test
    void test() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        assertThat(pair.getFirst()).isEqualTo(1);
        assertThat(pair.getSecond()).isEqualTo("hello");

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        assertThat(pair).isEqualTo(pair2);
        assertThat(pair.hashCode()).isEqualTo(pair2.hashCode());

        Pair<Integer, String> pair3 = Pair.of(2, "world");
        assertThat(pair).isNotEqualTo(pair3);
        assertThat(pair.hashCode()).isNotEqualTo(pair3.hashCode());
    }
}