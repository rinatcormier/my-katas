package org.stepik.course187.ch6_2ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            List<Integer> numbers = new ArrayList<>();
            boolean isOdd = false;
            while (in.hasNextInt()) {
                int num = in.nextInt();
                if (isOdd) {
                    numbers.add(num);
                    isOdd = false;
                } else {
                    isOdd = true;
                }
            }
            for (int i = numbers.size() - 1; i >= 0; i--) {
                System.out.print(numbers.get(i));
                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }
    }
}
