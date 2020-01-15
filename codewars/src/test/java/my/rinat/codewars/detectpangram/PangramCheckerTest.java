package my.rinat.codewars.detectpangram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PangramCheckerTest {

    private PangramChecker checker = new PangramChecker();

    @ParameterizedTest
    @MethodSource("checkTestCandidates")
    void testCheck(String string, boolean isPangram) {
        assertThat(checker.check(string)).isEqualTo(isPangram);
    }

    private static Stream<Arguments> checkTestCandidates() {
        return Stream.of(
                Arguments.of("The quick brown fox jumps over the lazy dog.", true),
                Arguments.of("You shall not pass!", false)
        );
    }
}