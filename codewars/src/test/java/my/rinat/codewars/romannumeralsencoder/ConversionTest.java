package my.rinat.codewars.romannumeralsencoder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionTest {

    @ParameterizedTest
    @MethodSource("toToRomanNumeralsTestCandidates")
    void testToRomanNumeral(int number, String roman) {
        var conversion = new Conversion();
        assertThat(conversion.solution(number)).isEqualTo(roman);
    }

    private static Stream<Arguments> toToRomanNumeralsTestCandidates() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(2, "II"),
                Arguments.of(1666, "MDCLXVI"),
                Arguments.of(1990, "MCMXC"),
                Arguments.of(2008, "MMVIII")
        );
    }
}