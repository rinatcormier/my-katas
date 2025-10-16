package huge_fibonacci_number;

import java.util.Scanner;

public class Main {

    private static long getHugeFibonacciModulo(long n, long m) {
        if (n <= 1) {
            return n;
        }
        long prev = 0;
        long curr = 1;
        for (long i = 0; i < n - 1; i++) {
            long temp = prev;
            prev = curr;
            curr = (temp + curr) % m;
        }
        return curr;
    }

    private static int pisanoPeriod(long m) {
        long current = 0;
        long next = 1;
        long prevNext;
        int period = 0;
        do {
            prevNext = next;
            next = (current + next) % m;
            current = prevNext;
            period++;
        } while (current != 0 || next != 1);
        return period;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        int p = pisanoPeriod(m);
        System.out.println(getHugeFibonacciModulo(n % p, m));
    }
}
