package org.stepik.course187.ch6_4ex3;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            stream(in.nextLine().split("[^\\wА-Яа-я]+"))
                    .map(String::toLowerCase)
                    .collect(groupingBy(identity(), counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .limit(10)
                    .forEach(entry -> System.out.println(entry.getKey()));
        }
    }
}
