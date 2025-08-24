package org.stepik.course217.ch4_1ex2;

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
                Arguments.of(separatedObjectsAsString("3 50", "60 20", "100 50", "120 30"), separatedObjectsAsString("180.000")),
                Arguments.of(separatedObjectsAsString("3 0", "60 20", "100 50", "120 30"), separatedObjectsAsString("0.000")),
                Arguments.of(separatedObjectsAsString("3 10", "60 20", "100 50", "120 30"), separatedObjectsAsString("40.000")),
                Arguments.of(separatedObjectsAsString("2 15", "12 20", "20 3"), separatedObjectsAsString("27.200")),
                Arguments.of(separatedObjectsAsString("5 9022", "3316 1601", "5375 8940", "2852 6912", "3336 9926", "1717 8427"), separatedObjectsAsString("7777.731"))
        );
    }

    private static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}
