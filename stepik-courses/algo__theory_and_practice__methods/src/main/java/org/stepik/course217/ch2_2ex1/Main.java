package org.stepik.course217.ch2_2ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(fib(in.nextInt()));
        }
    }

    private static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] fibs = new long[n + 1];
        fibs[0] = 0;
        fibs[1] = 1L;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n];
    }
}
