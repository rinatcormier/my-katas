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

    @Test
    void exercise_1_1_8() {
        StdOut.println('b');
        StdOut.println('b' + 'c');
        StdOut.println((char) ('a' + 4));
    }

    @ParameterizedTest
    @MethodSource("candidates_for_exercise_1_1_9")
    void exercise_1_1_9(int N, String result) {
        StringBuilder binaryRepresentation = new StringBuilder();
        for (int n = N; n > 0; n /= 2) {
            binaryRepresentation.insert(0, (n % 2));
        }
        assertThat(binaryRepresentation.toString()).isEqualTo(result);
    }

    private static Stream<Arguments> candidates_for_exercise_1_1_9() {
        return Stream.of(
                Arguments.of(1, Integer.toBinaryString(1)),
                Arguments.of(2, Integer.toBinaryString(2)),
                Arguments.of(100, Integer.toBinaryString(100))
        );
    }

    @Test
    void exercise_1_1_11() {
        boolean[][] booleans = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        StdOut.println("   1 2 3");
        for (int i = 0; i < booleans.length; i++) {
            StdOut.print((i + 1) + " ");
            for (int j = 0; j < booleans[i].length; j++) {
                StdOut.print(booleans[i][j] ? " *" : "  ");
            }
            StdOut.println();
        }
    }

    @Test
    void exercise_1_1_12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    void exercise_1_1_13() {
        int[][] arrays = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int[] array : arrays) {
            for (int item : array) {
                StdOut.print(" ");
                StdOut.print(item);
            }
            StdOut.println();
        }

        StdOut.println();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                StdOut.print(" ");
                StdOut.print(arrays[j][i]);
            }
            StdOut.println();
        }
    }

    @ParameterizedTest
    @MethodSource("candidates_for_exercise_1_1_14")
    void exercise_1_1_14(int x, int result) {
        assertThat(lg(x)).isEqualTo(result);
    }

    private static int lg(int x) {
        if (x == 1) {
            return x;
        }
        for (int i = 1; i <= x / 2; i++) {
            if ((i * i) <= x && ((i + 1) * (i + 1)) > x) {
                return i;
            }
        }
        throw new IllegalArgumentException("base-2 logarithm of x has not found");
    }

    private static Stream<Arguments> candidates_for_exercise_1_1_14() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 1),
                Arguments.of(4, 2),
                Arguments.of(5, 2),
                Arguments.of(6, 2),
                Arguments.of(7, 2),
                Arguments.of(8, 2),
                Arguments.of(9, 3),
                Arguments.of(10, 3),
                Arguments.of(11, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("candidates_for_exercise_1_1_15")
    void exercise_1_1_15(int[] a, int M, int[] expected) {
        assertThat(histogram(a, M)).containsExactly(expected);
    }

    private static int[] histogram(int[] a, int M) {
        int[] result = new int[M];

        for (int i = 0; i < result.length; i++) {
            int counter = 0;
            for (int value : a) {
                if (value == i) {
                    counter++;
                }
            }
            result[i] = counter;
        }

        return result;
    }

    private static Stream<Arguments> candidates_for_exercise_1_1_15() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 2, 3, 4, 5}, 10, new int[] {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}),
                Arguments.of(new int[] {1, 2, 2, 3, 3, 3}, 5, new int[] {0, 1, 2, 3, 0})
        );
    }

    @Test
    void exercise_1_1_16() {
        StdOut.println(exR1(6));
    }

    private static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    @Test
    void exercise_1_1_18() {
        assertThat(mystery(2, 25)).isEqualTo(50);
        assertThat(mystery(3, 11)).isEqualTo(33);
    }

    private static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

    @Test
    void exercise_1_1_19() {
        for (int N = 0; N < 100; N++) {
            f = null;
            StdOut.println(N + " " + F(N));
        }
    }

    private static int[] f;

    private static int F(int N) {
        if (N <= 0) {
            return 0;
        }
        if (f == null) {
            f = new int[N + 1];
            f[1] = 1;
        }
        if (f[N] != 0) {
            return f[N];
        } else {
            f[N] = F(N - 1) + F(N - 2);
            return f[N];
        }
    }
}
