package my.rinat.chapter1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import edu.princeton.util.StdOut;
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

    @ParameterizedTest
    @MethodSource("candidates_for_exercise_1_1_5")
    void exercise_1_1_5(double a, double b, boolean result) {
        assertThat(areStrictlyBetweenZeroAndOne(a, b)).isEqualTo(result);
    }

    private static boolean areStrictlyBetweenZeroAndOne(double x, double y) {
        return (x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0);
    }

    private static Stream<Arguments> candidates_for_exercise_1_1_5() {
        return Stream.of(
                Arguments.of(0.1, 0.9, true),
                Arguments.of(0.0, 0.9, false),
                Arguments.of(0.1, 1.0, false)
        );
    }

    @Test
    void exercise_1_1_6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @Test
    void exercise_1_1_7_a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
    }

    @Test
    void exercise_1_1_7_b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    @Test
    void exercise_1_1_7_c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }
}
