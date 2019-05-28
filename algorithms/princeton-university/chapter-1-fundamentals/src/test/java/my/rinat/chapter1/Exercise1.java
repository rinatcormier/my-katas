package my.rinat.chapter1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Exercise1 {

    @Test
    void exercise_1_1_1() {
        // @formatter:off
        //noinspection PointlessArithmeticExpression
        assertThat((0 + 15) / 2)                 .isEqualTo(7);
        assertThat(2.0e-6 * 100_000_000.1)       .isEqualTo(200.000_000_2, offset(0.0));
        //noinspection PointlessBooleanExpression,ConstantConditions
        assertThat(true && false || true && true).isTrue();
        // @formatter:on
    }

    @Test
    void exercise_1_1_2() {
        // @formatter:off
        assertThat((1 + 2.236) / 2).isEqualTo(1.618);
        assertThat(1 + 2 + 3 + 4.0).isEqualTo(10.0, offset(0.0));
        //noinspection ConstantConditions
        assertThat(4.1 >= 4)       .isTrue();
        assertThat(1 + 2 + "3")    .isEqualTo("33");
        // @formatter:on
    }

    @ParameterizedTest
    @MethodSource("candidates_for_exercise_1_1_3")
    void exercise_1_1_3(int a, int b, int c, String result) {
        assertThat(compareThreeArguments(a, b, c)).isEqualTo(result);
    }

    private static String compareThreeArguments(int a, int b, int c) {
        if (a == b && b == c) {
            return "equal";
        } else {
            return "not equal";
        }
    }

    private static Stream<Arguments> candidates_for_exercise_1_1_3() {
        return Stream.of(
                Arguments.of(1, 2, 3, "not equal"),
                Arguments.of(2, 2, 2, "equal")
        );
    }
}
