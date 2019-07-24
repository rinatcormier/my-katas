package org.stepik.course187.ch6_4ex1;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // must be: 13, 16, 25, 62, 384, 745, 502, 200, 0, ...
        pseudoRandomStream(13)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();
        pseudoRandomStream(23)
                .limit(10)
                .forEach(System.out::println);
    }

    private static IntStream pseudoRandomStream(int seed) {
        return IntStream
                .iterate(seed, item -> mid(item * item));
    }

    private static int mid(int seed) {
        return extractNumberPosition(seed, 4) * 100
                + extractNumberPosition(seed, 3) * 10
                + extractNumberPosition(seed, 2);
    }

    private static int extractNumberPosition(int number, int position) {
        return (number % ((int) Math.pow(10, position))) / ((int) Math.pow(10, position - 1));
    }
}
