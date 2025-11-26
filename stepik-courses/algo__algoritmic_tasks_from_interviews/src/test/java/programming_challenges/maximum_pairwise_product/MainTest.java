package programming_challenges.maximum_pairwise_product;

import beginning.maximum_pairwise_product.Main;
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
                Arguments.of(separatedObjectsAsString("3", "1 2 3"), separatedObjectsAsString("6")),
                Arguments.of(separatedObjectsAsString("10", "7 5 14 2 8 8 10 1 2 3"), separatedObjectsAsString("140")),
                Arguments.of(separatedObjectsAsString("2", "0 1"), separatedObjectsAsString("0")),
                Arguments.of(separatedObjectsAsString("5", "0 1 20000 20000 10000"), separatedObjectsAsString("400000000")),
                Arguments.of(separatedObjectsAsString("5", "0 1 10000 20000 10000"), separatedObjectsAsString("200000000")),
                Arguments.of(separatedObjectsAsString("2", "100000 90000"), separatedObjectsAsString("9000000000"))
        );
    }
}
