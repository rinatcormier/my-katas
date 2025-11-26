package beginning.last_digit_of_fibonacci_number;

import java.util.Scanner;

public class Main {

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1) {
            return n;
        }
        int prevLastDigit = 0;
        int currLastDigit = 1;
        for (int i = 1; i < n; i++) {
            int tempPrevLastDigit = prevLastDigit;
            prevLastDigit = currLastDigit;
            currLastDigit = (tempPrevLastDigit + currLastDigit) % 10;
        }
        return currLastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
