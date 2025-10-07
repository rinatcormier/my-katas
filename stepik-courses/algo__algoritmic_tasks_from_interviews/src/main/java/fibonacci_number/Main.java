package fibonacci_number;

import java.util.Scanner;

public class Main {

    private static long fib(int n, long[] memoization) {
        if (n <= 1) {
            return memoization[n];
        }
        if (memoization[n] == 0) {
            memoization[n] = fib(n - 2, memoization) + fib(n - 1, memoization);
        }
        return memoization[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        var memoization = new long[n + 1];
        memoization[0] = 0;
        if (n > 0) {
            memoization[1] = 1;
        }
        System.out.println(fib(n, memoization));
    }
}
