package n20_valid_parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testCandidates(String s, boolean expected) {
        assertThat(new Solution().isValid(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of(")]}", false),
                Arguments.of("{[()]}", true),
                Arguments.of("{", false)
        );
    }
}
