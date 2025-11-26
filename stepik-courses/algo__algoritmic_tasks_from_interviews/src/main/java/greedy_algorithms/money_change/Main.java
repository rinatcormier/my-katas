package greedy_algorithms.money_change;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            var tens = n / 10;
            var fives = (n % 10) / 5;
            var ones = (n % 10) % 5;
            System.out.println(tens + fives + ones);
        }
    }
}
