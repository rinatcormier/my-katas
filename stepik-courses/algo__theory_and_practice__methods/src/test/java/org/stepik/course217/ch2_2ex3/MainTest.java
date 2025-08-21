package org.stepik.course217.ch2_2ex3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest { 

    @ParameterizedTest
    @MethodSource("smallCases")
    void testSmallCases(long n, int m) {
        long expected = naiveFibMod(n, m);
        runAndAssert(n, m, expected);
    }

    @ParameterizedTest
    @MethodSource("largeKnownCases")
    void testLargeKnownCases(long n, int m, long expected) {
        runAndAssert(n, m, expected);
    }

    private static void runAndAssert(long n, int m, long expected) {
        String input = n + " " + m;
        try (ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
            try {
                System.setIn(in);
                System.setOut(new PrintStream(out));
                Main.main(new String[]{});
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
            assertThat(out.toString()).isEqualTo(expected + System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long naiveFibMod(long n, int m) {
        if (m == 1) return 0;
        long a = 0;
        long b = 1 % m;
        for (long i = 0; i < n; i++) {
            long tmp = (a + b) % m;
            a = b;
            b = tmp;
        }
        return a % m;
    }

    private static Stream<Arguments> smallCases() {
        return Stream.of(
                Arguments.of(0L, 2),
                Arguments.of(1L, 2),
                Arguments.of(2L, 2),
                Arguments.of(3L, 2),
                Arguments.of(10L, 2),
                Arguments.of(9L, 10),
                Arguments.of(10L, 10),
                Arguments.of(50L, 97),
                Arguments.of(100L, 97),
                Arguments.of(1000L, 997)
        );
    }

    private static Stream<Arguments> largeKnownCases() {
        return Stream.of(
                Arguments.of(0L, 2, 0L),
                Arguments.of(1L, 2, 1L),
                Arguments.of(3L, 2, 0L),
                Arguments.of(10L, 2, 1L),
                Arguments.of(9L, 10, 4L),
                Arguments.of(10L, 10, 5L),
                // Very large n with small mod values, using Pisano period properties
                Arguments.of(1_000_000_000_000_000_000L, 2, 1L), // n % 3 = 1 -> F(n) % 2 = 1
                Arguments.of(1_000_000_000_000_000_000L, 3, 0L), // period 8, n % 8 = 0
                Arguments.of(1_000_000_000_000_000_000L, 5, 0L), // period 20, n % 20 = 0
                Arguments.of(1_000_000_000_000_000_000L, 10, 5L), // period 60, n % 60 = 40 -> F(40) % 10 = 5
                Arguments.of(999_999_999_999_999_999L, 2, 0L) // (10^18 - 1) % 3 = 0 -> F(n) % 2 = 0
        );
    }
}
