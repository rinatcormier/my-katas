package fibonacci_number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.MockedStdIO;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Utils.separatedObjectsAsString;

class MainTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testCandidates(String input, String expected) {
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expected);
        });
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(separatedObjectsAsString("0"), separatedObjectsAsString("0")),
                Arguments.of(separatedObjectsAsString("1"), separatedObjectsAsString("1")),
                Arguments.of(separatedObjectsAsString("2"), separatedObjectsAsString("1")),
                Arguments.of(separatedObjectsAsString("3"), separatedObjectsAsString("2")),
                Arguments.of(separatedObjectsAsString("4"), separatedObjectsAsString("3")),
                Arguments.of(separatedObjectsAsString("5"), separatedObjectsAsString("5")),
                Arguments.of(separatedObjectsAsString("6"), separatedObjectsAsString("8"))
        );
    }
}