package complexity_from_11_to_20.task_550;

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
                Arguments.of(separatedObjectsAsString("2000"), separatedObjectsAsString("12/09/2000")),
                Arguments.of(separatedObjectsAsString("2009"), separatedObjectsAsString("13/09/2009")),
                Arguments.of(separatedObjectsAsString("400"), separatedObjectsAsString("12/09/0400")),
                Arguments.of(separatedObjectsAsString("404"), separatedObjectsAsString("12/09/0404")),
                Arguments.of(separatedObjectsAsString("500"), separatedObjectsAsString("13/09/0500")),
                Arguments.of(separatedObjectsAsString("1996"), separatedObjectsAsString("12/09/1996")),
                Arguments.of(separatedObjectsAsString("1"), separatedObjectsAsString("13/09/0001")),
                Arguments.of(separatedObjectsAsString("10"), separatedObjectsAsString("13/09/0010"))
        );
    }
}
