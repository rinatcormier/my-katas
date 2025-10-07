package complexity_from_0_to_10.task_685;

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
                Arguments.of(separatedObjectsAsString("1 2 3 3 2 1"), separatedObjectsAsString("14")),
                Arguments.of(separatedObjectsAsString("1 1 1 3 2 1"), separatedObjectsAsString("6")),
                Arguments.of(separatedObjectsAsString("100 99 98 100 10 1"), separatedObjectsAsString("11088"))
        );
    }
}
