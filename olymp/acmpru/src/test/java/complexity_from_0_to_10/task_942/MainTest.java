package complexity_from_0_to_10.task_942;

import complexity_from_0_to_10.util.MockedStdIO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

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
                Arguments.of(separatedObjectsAsString(3, "40 30 60"), separatedObjectsAsString(1)),
                Arguments.of(separatedObjectsAsString(4, "10 20 30 40"), separatedObjectsAsString(1)),
                Arguments.of(separatedObjectsAsString(1, "10"), separatedObjectsAsString(1)),
                Arguments.of(separatedObjectsAsString(5, "10 10 10 10 10"), separatedObjectsAsString(1))
        );
    }

    private static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}