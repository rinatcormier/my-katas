package greedy_algorithms.car_fueling;

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
                Arguments.of(separatedObjectsAsString("50", "100", "0", ""), separatedObjectsAsString("0")),
                Arguments.of(separatedObjectsAsString("100", "50", "0", ""), separatedObjectsAsString("-1")),
                Arguments.of(separatedObjectsAsString("950", "400", "4", "200 375 550 750"), separatedObjectsAsString("2")),
                Arguments.of(separatedObjectsAsString("10", "3", "4", "1 2 5 9"), separatedObjectsAsString("-1")),
                Arguments.of(separatedObjectsAsString("10", "3", "3", "1 2 5"), separatedObjectsAsString("-1")),
                Arguments.of(separatedObjectsAsString("200", "250", "2", "100 150"), separatedObjectsAsString("0"))
        );
    }
}
