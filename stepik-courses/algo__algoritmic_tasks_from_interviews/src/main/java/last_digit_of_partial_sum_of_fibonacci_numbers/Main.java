package last_digit_of_partial_sum_of_fibonacci_numbers;

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
        long m = scanner.nextLong();
        int p = pisanoPeriod();
        var sumN = getFibonacciModulo((n + 1) % p);
        var sumM = getFibonacciModulo((m + 2) % p);
        sumN = sumN == 0 ? 9 : sumN - 1;
        sumM = sumM == 0 ? 9 : sumM - 1;
        if (sumM < sumN) {
            sumM += 10;
        }
        System.out.println(sumM - sumN);
    }
}
