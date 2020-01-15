package my.rinat.codewars.validatepin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("validatePinTestCandidates")
    void testValidatePin(String pin, boolean isValid) {
        assertThat(Solution.validatePin(pin)).isEqualTo(isValid);
    }

    private static Stream<Arguments> validatePinTestCandidates() {
        return Stream.of(
                Arguments.of("1234", true),
                Arguments.of("0000", true),
                Arguments.of("12345", false),
                Arguments.of("00000", false),
                Arguments.of("123456", true),
                Arguments.of("000000", true),
                Arguments.of("....", false),
                Arguments.of("......", false),
                Arguments.of("123a", false),
                Arguments.of("a23456", false)
        );
    }
}