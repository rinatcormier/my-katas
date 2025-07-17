package chapter2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortJunieTest {

    @ParameterizedTest
    @MethodSource("selectionSortCandidates")
    void selectionSort(int[] unordered, int[] expected) {
        final var actual = SelectionSortJunie.selectionSort(unordered);
        assertThat(actual)
                .isEqualTo(expected);
    }

    private static Stream<Arguments> selectionSortCandidates() {
        return Stream.of(
                // Basic test cases from original test
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{7, -7, 4, 5, -3}, new int[]{-7, -3, 4, 5, 7}),
                
                // Additional test cases for more comprehensive testing
                // Arrays with duplicate values
                Arguments.of(new int[]{3, 3, 3}, new int[]{3, 3, 3}),
                Arguments.of(new int[]{5, 2, 5, 1, 5}, new int[]{1, 2, 5, 5, 5}),
                Arguments.of(new int[]{4, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 4}),
                
                // Arrays with extreme values
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 
                             new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}),
                
                // Larger arrays
                Arguments.of(
                    new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5},
                    new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
                ),
                
                // Random order array
                Arguments.of(
                    new int[]{42, 17, 9, -3, 25, 8, 0, 13, -7, 21, 4},
                    new int[]{-7, -3, 0, 4, 8, 9, 13, 17, 21, 25, 42}
                )
        );
    }

    @Test
    void notModified() {
        int[] unordered = new int[]{7, -7, 4, 5, -3};
        int[] original = Arrays.copyOf(unordered, unordered.length);
        SelectionSortJunie.selectionSort(unordered);
        assertThat(unordered)
                .isEqualTo(original)
                .describedAs("Original array should not be modified");
    }
    
    @Test
    void compareWithJavaSort() {
        int[] unordered = new int[]{42, 17, 9, -3, 25, 8, 0, 13, -7, 21, 4};
        int[] expected = Arrays.copyOf(unordered, unordered.length);
        Arrays.sort(expected);
        
        int[] actual = SelectionSortJunie.selectionSort(unordered);
        
        assertThat(actual)
                .isEqualTo(expected)
                .describedAs("Selection sort should produce the same result as Java's built-in sort");
    }
    
    @Test
    void largeRandomArray() {
        // Create a large array with 1000 random elements
        int[] large = new int[1000];
        for (int i = 0; i < large.length; i++) {
            large[i] = (int) (Math.random() * 10000) - 5000; // Random values between -5000 and 5000
        }
        
        int[] expected = Arrays.copyOf(large, large.length);
        Arrays.sort(expected);
        
        int[] actual = SelectionSortJunie.selectionSort(large);
        
        assertThat(actual)
                .isEqualTo(expected)
                .describedAs("Selection sort should correctly sort a large random array");
    }
}