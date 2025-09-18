package complexity_from_0_to_10.task_754;

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
                Arguments.of(separatedObjectsAsString("98 106 214"), separatedObjectsAsString("214")),
                Arguments.of(separatedObjectsAsString("100 100 100"), separatedObjectsAsString("100")),
                Arguments.of(separatedObjectsAsString("93 500 1000"), separatedObjectsAsString("Error"))
        );
    }
}
