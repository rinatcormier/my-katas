package n13_roman_to_integer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testCandidates(String s, int expected) {
        assertThat(new Solution().romanToInt(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("IV", 4),
                Arguments.of("IX", 9),
                Arguments.of("XIV", 14),
                Arguments.of("XIX", 19),
                Arguments.of("XL", 40),
                Arguments.of("XC", 90),
                Arguments.of("CXL", 140),
                Arguments.of("CXC", 190)
        );
    }
}
