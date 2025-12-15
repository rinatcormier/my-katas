package greedy_algorithms.maximum_advertisement_revenue;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        var prices = new int[n];
        var clicks = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            clicks[i] = scanner.nextInt();
        }
        Arrays.sort(prices);
        Arrays.sort(clicks);
        long revenue = 0;
        for (int i = 0; i < n; i++) {
            revenue += ((long) prices[i] * clicks[i]);
        }
        System.out.println(revenue);
    }
}
