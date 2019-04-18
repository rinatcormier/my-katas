package my.rinat.chapter1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Exercise0 {

    @ParameterizedTest
    @MethodSource("gcdTestCandidates")
    void testGcd(int p, int q, int expectedGcd) {
        Assertions.assertThat(Math.gcd(p, q)).isEqualTo(expectedGcd);
    }

    private static Stream<Arguments> gcdTestCandidates() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(3, 2, 1),
                Arguments.of(14, 7, 7),
                Arguments.of(125, 25, 25)
        );
    }
}
