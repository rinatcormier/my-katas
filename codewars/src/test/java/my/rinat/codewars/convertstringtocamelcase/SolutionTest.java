package my.rinat.codewars.convertstringtocamelcase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static my.rinat.codewars.convertstringtocamelcase.Solution.capitalize;
import static my.rinat.codewars.convertstringtocamelcase.Solution.toCamelCase;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCapitalize() {
        assertThat(capitalize("capitalized")).isEqualTo("Capitalized");
    }

    @ParameterizedTest
    @MethodSource("toCamelCaseTestCandidates")
    void testToCamelCase(String source, String result) {
        assertThat(toCamelCase(source)).isEqualTo(result);
    }

    private static Stream<Arguments> toCamelCaseTestCandidates() {
        return Stream.of(
                Arguments.of("the-stealth-warrior", "theStealthWarrior"),
                Arguments.of("The_Stealth_Warrior", "TheStealthWarrior")
        );
    }
}