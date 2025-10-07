package complexity_from_0_to_10.task_819;

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
                Arguments.of(separatedObjectsAsString("1 1 1"), separatedObjectsAsString("6 1")),
                Arguments.of(separatedObjectsAsString("2 3 4"), separatedObjectsAsString("52 24")),
                Arguments.of(separatedObjectsAsString("1000000 999999 999998"), separatedObjectsAsString("5999988000004 999997000002000000"))
        );
    }
}