package last_digit_of_fibonacci_number;

import beginning.last_digit_of_fibonacci_number.Main;
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
                Arguments.of(separatedObjectsAsString("3"), separatedObjectsAsString("2")),
                Arguments.of(separatedObjectsAsString("139"), separatedObjectsAsString("1")),
                Arguments.of(separatedObjectsAsString("91239"), separatedObjectsAsString("6"))
        );
    }
}
