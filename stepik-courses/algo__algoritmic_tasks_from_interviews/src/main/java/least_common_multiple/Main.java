package least_common_multiple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(((long) a * b) / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        return gcd(b, a % b);
    }
}
