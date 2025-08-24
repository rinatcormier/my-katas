package chapter2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("selectionSortCandidates")
    void selectionSort(int[] unordered, int[] expected) {
        final var actual = SelectionSort.selectionSort(unordered);
        assertThat(actual)
                .isEqualTo(expected);
    }

    private static Stream<Arguments> selectionSortCandidates() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{7, -7, 4, 5, -3}, new int[]{-7, -3, 4, 5, 7})
        );
    }

    @Test
    void notModified() {
        int[] unordered = new int[]{7, -7, 4, 5, -3};
        SelectionSort.selectionSort(unordered);
        assertThat(unordered)
                .isEqualTo(new int[]{7, -7, 4, 5, -3});
    }
}
