package complexity_from_11_to_20.task_514;

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
                Arguments.of(separatedObjectsAsString("1"), separatedObjectsAsString("1")),
                Arguments.of(separatedObjectsAsString("4"), separatedObjectsAsString("2")),
                Arguments.of(separatedObjectsAsString("6"), separatedObjectsAsString("3")),
                Arguments.of(separatedObjectsAsString("1000000"), separatedObjectsAsString("1413"))
        );
    }
}
