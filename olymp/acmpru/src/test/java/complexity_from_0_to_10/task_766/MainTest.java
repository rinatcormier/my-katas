package complexity_from_0_to_10.task_766;

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
                Arguments.of(separatedObjectsAsString("4 5 20"), separatedObjectsAsString("YES")),
                Arguments.of(separatedObjectsAsString("4 5 21"), separatedObjectsAsString("NO")),
                Arguments.of(separatedObjectsAsString("3 2 1"), separatedObjectsAsString("YES")),
                Arguments.of(separatedObjectsAsString("1 1 2"), separatedObjectsAsString("NO"))
        );
    }
}
