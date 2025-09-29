package n1_two_sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest(name = "{index}: input({0}), target({1}), expected({2})")
    @MethodSource("candidates")
    void testCandidates(int[] nums, int target, int[] expected) {
        assertThat(new Solution().twoSum(nums, target))
                .containsExactly(expected);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}