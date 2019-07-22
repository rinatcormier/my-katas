package org.stepik.course187.ch6_2ex1;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class MainTest {

    @ParameterizedTest
    @MethodSource("candidates")
    void testSymmetricDifference(Set<Integer> set1, Set<Integer> set2, Set<Integer> symmetricDifference) {
        assertThat(Main.symmetricDifference(set1, set2)).containsExactlyElementsOf(symmetricDifference);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(new HashSet<>(asList(1, 2, 3)), new HashSet<>(asList(0, 1, 2)), new HashSet<>(asList(0, 3)))
        );
    }
}