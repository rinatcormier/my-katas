package complexity_from_0_to_10.task_892;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.MockedStdIO;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Utils.separatedObjectsAsString;

class MainTest {

    @ParameterizedTest
    @MethodSource("candidates")
    void testCandidates(String input, String expected) {
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expected);
        });
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(separatedObjectsAsString("1"), separatedObjectsAsString("Winter")),
                Arguments.of(separatedObjectsAsString("2"), separatedObjectsAsString("Winter")),
                Arguments.of(separatedObjectsAsString("3"), separatedObjectsAsString("Spring")),
                Arguments.of(separatedObjectsAsString("8"), separatedObjectsAsString("Summer")),
                Arguments.of(separatedObjectsAsString("11"), separatedObjectsAsString("Autumn")),
                Arguments.of(separatedObjectsAsString("12"), separatedObjectsAsString("Winter")),
                Arguments.of(separatedObjectsAsString("13"), separatedObjectsAsString("Error"))
        );
    }
}