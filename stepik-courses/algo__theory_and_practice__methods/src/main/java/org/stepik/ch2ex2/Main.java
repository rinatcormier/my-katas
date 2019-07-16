package org.stepik.ch2ex2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(fibLastDigit(in.nextInt()));
        }
    }

    private static long fibLastDigit(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] fibLastDigits = new long[n + 1];
        fibLastDigits[0] = 0;
        fibLastDigits[1] = 1L;
        for (int i = 2; i <= n; i++) {
            fibLastDigits[i] = (fibLastDigits[i - 1] + fibLastDigits[i - 2]) % 10;
        }
        return fibLastDigits[n];
    }
}
