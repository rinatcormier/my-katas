package training1.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.MockedStdIO;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @ParameterizedTest
    @MethodSource("primesRangeCandidates")
    void testPrimesRange(int from, int to, String expected) {
        final String input = from + " " + to;
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expected);
        });
    }

    private static Stream<Arguments> primesRangeCandidates() {
        return Stream.of(
                Arguments.of(2, 2, separatedObjectsAsString(2)),
                Arguments.of(2, 3, separatedObjectsAsString(2, 3)),
                Arguments.of(3, 3, separatedObjectsAsString(3)),
                Arguments.of(4, 4, separatedObjectsAsString("Absent")),
                Arguments.of(8, 10, separatedObjectsAsString("Absent")),
                Arguments.of(2, 5, separatedObjectsAsString(2, 3, 5)),
                Arguments.of(299970, 300000, separatedObjectsAsString(299977, 299983, 299993))
        );
    }

    private static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}