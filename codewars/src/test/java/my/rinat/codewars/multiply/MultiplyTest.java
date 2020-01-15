package my.rinat.codewars.multiply;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static my.rinat.codewars.multiply.Multiply.multiply;
import static org.assertj.core.api.Assertions.assertThat;

class MultiplyTest {

    @ParameterizedTest
    @MethodSource("multiplyTestCandidates")
    void testMultiply(double a, double b, double result) {
        assertThat(multiply(a, b)).isEqualTo(result);
    }

    private static Stream<Arguments> multiplyTestCandidates() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(1, 2, 2),
                Arguments.of(2, 2, 4),
                Arguments.of(4, 5, 20)
        );
    }
}