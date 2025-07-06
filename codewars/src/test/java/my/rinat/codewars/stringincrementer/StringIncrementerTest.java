package my.rinat.codewars.stringincrementer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringIncrementerTest {

    @ParameterizedTest
    @MethodSource("incNumberByOneCandidates")
    void incNumberByOne(String parameter, String expected) {
        final var actual = StringIncrementer.incrementString(parameter);
        assertThat(actual)
                .isEqualTo(expected);
    }

    private static Stream<Arguments> incNumberByOneCandidates() {
        return Stream.of(
                Arguments.of("1", "2"),
                Arguments.of("01", "02"),
                Arguments.of("foo", "foo1"),
                Arguments.of("foo1", "foo2"),
                Arguments.of("foo01", "foo02"),
                Arguments.of("foo99", "foo100"),
                Arguments.of("foo099", "foo100"),
                Arguments.of("foo111111111111111111111111111111111111111111111111111111111111", "foo111111111111111111111111111111111111111111111111111111111112"),
                Arguments.of("d0000000000000000000000000000000000", "d0000000000000000000000000000000001")
        );
    }
}
