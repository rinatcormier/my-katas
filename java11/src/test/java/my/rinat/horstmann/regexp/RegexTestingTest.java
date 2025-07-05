package my.rinat.horstmann.regexp;

import my.rinat.util.MockedStdIO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

class RegexTestingTest {

    @ParameterizedTest
    @MethodSource("regexCandidates")
    void printsGroupedMatchedString(String input, String expectedGroupedMatchedString) {
        new MockedStdIO(input).run(output -> {
            RegexTesting.main(new String[]{});
            assertThat(output.toString()).isEqualTo(expectedGroupedMatchedString);
        });
    }

    private static Stream<Arguments> regexCandidates() {
        String eol = System.lineSeparator();
        return Stream.of(
                Arguments.of(
                        format("(([1-9]|1[0-2]):([0-5][0-9]))[ap]m%s11:59am%s%s",
                                eol, eol, eol),
                        format("Enter pattern:%sEnter string to match:%sMatch%s((11):(59))am%sEnter string to match:%s",
                                eol, eol, eol, eol, eol)
                )
        );
    }
}
