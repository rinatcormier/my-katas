package complexity_from_0_to_10.task_757;

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
                Arguments.of(separatedObjectsAsString("2 6 1"), separatedObjectsAsString("1")),
                Arguments.of(separatedObjectsAsString("10 5 12"), separatedObjectsAsString("0")),
                Arguments.of(separatedObjectsAsString("18 35 3"), separatedObjectsAsString("3"))
        );
    }
}
