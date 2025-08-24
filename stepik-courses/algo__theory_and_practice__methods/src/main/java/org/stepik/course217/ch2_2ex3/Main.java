package org.stepik.course217.ch2_2ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long n = in.nextLong();
            int m = in.nextInt();
            System.out.println(fibModLarge(n, m));
        }
    }

    // Computes F_n mod m for very large n using Pisano period and fast doubling
    private static int fibModLarge(long n, int m) {
        if (m == 1) return 0; // though constraints say m >= 2
        long period = pisanoPeriod(m);
        long nReduced = (period == 0) ? 0 : (n % period);
        return (int) fibMod(nReduced, m);
    }

    // Fast doubling (recursive): returns F_n mod m
    private static long fibMod(long n, int m) {
        return fibPair(n, m)[0];
    }

    // Returns array [F(n) mod m, F(n+1) mod m]
    private static long[] fibPair(long n, int m) {
        if (n == 0) return new long[]{0, 1 % m};
        long[] ab = fibPair(n >> 1, m);
        long a = ab[0];      // F(k)
        long b = ab[1];      // F(k+1)
        // c = F(2k) = F(k) * (2*F(k+1) − F(k))
        long twoB = (2 * b) % m;
        long twoBminusA = twoB - a;
        if (twoBminusA < 0) twoBminusA += m;
        long c = (a * (twoBminusA % m)) % m;
        // d = F(2k+1) = F(k)^2 + F(k+1)^2
        long d = ((a * a) % m + (b * b) % m) % m;
        if ((n & 1L) == 0) {
            return new long[]{c, d};
        } else {
            // F(2k+2) = F(2k) + F(2k+1)
            long e = (c + d) % m;
            return new long[]{d, e};
        }
    }

    // Pisano period for modulo m: length until 0,1 repeats
    private static long pisanoPeriod(int m) {
        int prev = 0;
        int curr = 1;
        for (long i = 0; i < (long) m * 6; i++) { // period <= 6m
            int next = (prev + curr) % m;
            prev = curr;
            curr = next;
            if (prev == 0 && curr == 1) {
                return i + 1;
            }
        }
        return 0; // should not reach
    }
}
