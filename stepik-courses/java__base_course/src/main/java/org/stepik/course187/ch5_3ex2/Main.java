package org.stepik.course187.ch5_3ex2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            double sum = 0;
            while (in.hasNext()) {
                String string = in.next();
                double number;
                try {
                    number = Double.parseDouble(string);
                } catch (NumberFormatException ignore) {
                    number = 0;
                }
                sum += number;
            }
            System.out.printf(Locale.ENGLISH, "%.6f", sum);
        }
    }
}
