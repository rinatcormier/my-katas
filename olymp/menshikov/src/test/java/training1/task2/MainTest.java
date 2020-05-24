package training1.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.MockedStdIO;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @ParameterizedTest
    @MethodSource("makeExpressionCandidates")
    void testIsExpressionPossible(String input, String expectedExpression) {
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expectedExpression);
        });
    }

    private static Stream<Arguments> makeExpressionCandidates() {
        String eol = System.lineSeparator();
        return Stream.of(
                Arguments.of(format("3 10%s15 25 30", eol), format("15+25-30=10%s", eol)),
                Arguments.of(format("2 100%s10 10", eol), format("No solution%s", eol)),
                Arguments.of(format("5 15%s1 2 3 4 5", eol), format("1+2+3+4+5=15%s", eol)),
                Arguments.of(format("3 7%s10 2 1", eol), format("10-2-1=7%s", eol))
        );
    }
}