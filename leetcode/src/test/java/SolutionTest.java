import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testCandidates(int[] nums, int k, int expected) {
        // assertThat(new Solution().findKthLargest(nums, k))
        //         .isEqualTo(expected);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                // Arguments.of(...args)
        );
    }
}
