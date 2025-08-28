package org.stepik.course217.ch4_1ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://stepik.org/lesson/13238/step/11?unit=3424">Problem.</a>
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<Integer> terms = new ArrayList<>();
            int m = 1;
            while (n > 0) {
                if (n - (m * 2) > 0) {
                    terms.add(m);
                    n -= m;
                } else {
                    terms.add(n);
                    n -= n;
                }
                m++;
            }
            System.out.println(terms.size());
            System.out.println(terms.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
