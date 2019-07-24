package org.stepik.course187.ch6_4ex2;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        findMinMax(Stream.of(1, 2, 3, 4, 5), comparingInt(item -> item), (a, b) -> System.out.println(a + " " + b));
    }

    private static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Set<? extends T> streamItems = stream.collect(Collectors.toSet());
        Optional<? extends T> min = streamItems.stream().min(order);
        Optional<? extends T> max = streamItems.stream().max(order);
        minMaxConsumer.accept(min.orElse(null), max.orElse(null));
    }
}
