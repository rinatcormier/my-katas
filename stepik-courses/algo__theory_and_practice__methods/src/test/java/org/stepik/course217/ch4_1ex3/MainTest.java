package org.stepik.course217.ch4_1ex3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.course217.util.MockedStdIO;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testMain(String input, String expected) {
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expected);
        });
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(separatedObjectsAsString("1"), separatedObjectsAsString("1", "1")),
                Arguments.of(separatedObjectsAsString("2"), separatedObjectsAsString("1", "2")),
                Arguments.of(separatedObjectsAsString("4"), separatedObjectsAsString("2", "1 3")),
                Arguments.of(separatedObjectsAsString("6"), separatedObjectsAsString("3", "1 2 3")),
                Arguments.of(separatedObjectsAsString("7"), separatedObjectsAsString("3", "1 2 4")),
                Arguments.of(separatedObjectsAsString("55"), separatedObjectsAsString("10", "1 2 3 4 5 6 7 8 9 10"))
        );
    }

    private static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}
