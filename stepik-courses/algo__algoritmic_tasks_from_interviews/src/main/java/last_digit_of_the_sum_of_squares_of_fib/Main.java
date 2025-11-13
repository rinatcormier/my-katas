package last_digit_of_the_sum_of_squares_of_fib;

import java.util.Scanner;

public class Main {

    private static long getFibonacciModulo(long n) {
        if (n <= 1) {
            return n;
        }
        long prev = 0;
        long curr = 1;
        for (long i = 0; i < n - 1; i++) {
            long temp = prev;
            prev = curr;
            curr = (temp + curr) % 10;
        }
        return curr;
    }

    private static int pisanoPeriod() {
        long current = 0;
        long next = 1;
        long prevNext;
        int period = 0;
        do {
            prevNext = next;
            next = (current + next) % 10;
            current = prevNext;
            period++;
        } while (current != 0 || next != 1);
        return period;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int p = pisanoPeriod();
        var a = getFibonacciModulo(n % p);
        var b = getFibonacciModulo((n + 1) % p);
        System.out.println((a * b) % 10);
    }
}
