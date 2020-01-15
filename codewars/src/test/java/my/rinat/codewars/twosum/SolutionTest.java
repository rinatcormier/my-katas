package my.rinat.codewars.twosum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("twoSumTestCandidates")
    void testTwoSum(int[] numbers, int target, int[] indexes) {
        assertThat(Solution.twoSum(numbers, target)).containsExactly(indexes);
    }

    private static Stream<Arguments> twoSumTestCandidates() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 4, new int[]{0, 2}),
                Arguments.of(new int[]{1234, 5678, 9012}, 5678 + 9012, new int[]{1, 2}),
                Arguments.of(new int[]{2, 2, 3}, 2 + 3, new int[]{0, 2})
        );
    }
}