package my.rinat.codewars.mumbling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AccumulTest {

    @ParameterizedTest
    @MethodSource("accumTestCandidates")
    void testAccum(String in, String out) {
        assertThat(Accumul.accum(in)).isEqualTo(out);
    }

    private static Stream<Arguments> accumTestCandidates() {
        return Stream.of(
                Arguments.of("abcd", "A-Bb-Ccc-Dddd"),
                Arguments.of("RqaEzty", "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"),
                Arguments.of("cwAt", "C-Ww-Aaa-Tttt")
        );
    }
}