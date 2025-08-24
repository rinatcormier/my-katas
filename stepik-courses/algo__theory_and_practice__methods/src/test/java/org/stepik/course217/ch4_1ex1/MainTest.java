package org.stepik.course217.ch4_1ex1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.course217.util.MockedStdIO;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @ParameterizedTest
    @MethodSource("candidates")
    void testMain(String input, String expected) {
        new MockedStdIO(input).run(output -> {
            Main.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expected);
        });
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(separatedObjectsAsString("3", "1 3", "2 5", "3 6"), separatedObjectsAsString("1", "3")),
                Arguments.of(separatedObjectsAsString("4", "4 7", "1 3", "2 5", "5 6"), separatedObjectsAsString("2", "3 6")),
                Arguments.of(separatedObjectsAsString("6", "2 5", "3 5", "4 5", "8 12", "9 19", "11 14"), separatedObjectsAsString("2", "5 12")),
                Arguments.of(separatedObjectsAsString("2", "1 3", "3 4"), separatedObjectsAsString("1", "3")),
                Arguments.of(separatedObjectsAsString("2", "1 30", "3 4"), separatedObjectsAsString("1", "4")),
                Arguments.of(separatedObjectsAsString("5", "5 6", "4 7", "3 8", "2 9", "1 10"), separatedObjectsAsString("1", "6")),
                Arguments.of(separatedObjectsAsString("5", "1 2", "2 3", "3 4", "4 5", "5 6"), separatedObjectsAsString("3", "2 4 6")),
                Arguments.of(separatedObjectsAsString("5", "1 2", "3 4", "5 6", "7 8", "9 10"), separatedObjectsAsString("5", "2 4 6 8 10")),
                Arguments.of(separatedObjectsAsString("1", "5 6"), separatedObjectsAsString("1", "6")),
                Arguments.of(separatedObjectsAsString("1", "1 1"), separatedObjectsAsString("1", "1")),
                Arguments.of(separatedObjectsAsString("1", "0 0"), separatedObjectsAsString("1", "0"))
        );
    }

    private static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}