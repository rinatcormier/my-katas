package greedy_algorithms.maximum_value_of_the_loot;

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
                Arguments.of(separatedObjectsAsString("3 50", "60 20", "100 50", "120 30"), separatedObjectsAsString("180.0000")),
                Arguments.of(separatedObjectsAsString("1 10", "500 30"), separatedObjectsAsString("166.6667")),
                Arguments.of(separatedObjectsAsString("1 1000", "500 30"), separatedObjectsAsString("500.0000"))
        );
    }
}