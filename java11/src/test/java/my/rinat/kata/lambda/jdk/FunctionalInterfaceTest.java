package my.rinat.kata.lambda.jdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.impl.list.Interval;
import org.junit.jupiter.api.Test;

/**
 * This test will illustrate how you can use lambdas with Functional Interface types introduced in Java 8
 * like Consumer, Function and Predicate.
 * <p>
 * Please refer to this tutorial for an overview of Lambdas for Java 8.
 *
 * @see <a href="http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html">Lambda Quickstart</a>
 * <p>
 * Then follow the TODOs in each test and convert the anonymous inner classes to lambdas and/or method references.
 */
class FunctionalInterfaceTest {
    @Test
    void consumer() {
        var strings = List.of("one", "two", "three");

        // TODO - Can you remove the final keyword from the variable below?
        final var result = new ArrayList<String>();

        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new Consumer<String>() {
            @Override
            public void accept(String each) {
                result.add(each.toUpperCase());
            }
        };
        consumer.accept("zero");
        Assertions.assertThat(result).isEqualTo(List.of("ZERO"));
        strings.forEach(consumer);
        Assertions.assertThat(result).isEqualTo(List.of("ZERO", "ONE", "TWO", "THREE"));
    }

    @Test
    void predicateIsEven() {
        var numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // TODO - Convert the anonymous inner class to a lambda
        var evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Assertions.assertThat(evenPredicate.test(2)).isTrue();
        Assertions.assertThat(evenPredicate.test(1)).isFalse();
        var evens = numbers.stream().filter(evenPredicate).collect(Collectors.toList());
        Assertions.assertThat(evens.stream().allMatch(evenPredicate)).isTrue();
        Assertions.assertThat(evens.stream().noneMatch(evenPredicate)).isFalse();
        Assertions.assertThat(evens.stream().anyMatch(evenPredicate)).isTrue();
        Assertions.assertThat(evens).isEqualTo(Interval.evensFromTo(1, 10));
    }

    @Test
    void predicateIsOdd() {
        var numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // TODO - Convert the anonymous inner class to a lambda
        var oddPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        };
        Assertions.assertThat(oddPredicate.test(2)).isFalse();
        Assertions.assertThat(oddPredicate.test(1)).isTrue();
        var odds = numbers.stream().filter(oddPredicate).collect(Collectors.toList());
        Assertions.assertThat(odds.stream().allMatch(oddPredicate)).isTrue();
        Assertions.assertThat(odds.stream().noneMatch(oddPredicate)).isFalse();
        Assertions.assertThat(odds.stream().anyMatch(oddPredicate)).isTrue();
        Assertions.assertThat(odds).isEqualTo(Interval.oddsFromTo(1, 10));
    }

    @Test
    void function() {
        // TODO - Convert the anonymous inner class to a lambda and then a method reference
        var toUppercase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        Assertions.assertThat(toUppercase.apply("uppercase")).isEqualTo("UPPERCASE");
        List<String> lowercase = List.of("a", "b", "c", "d");
        Set<String> uppercase = lowercase.stream().map(toUppercase).collect(Collectors.toSet());
        Assertions.assertThat(uppercase).isEqualTo(Set.of("A", "B", "C", "D"));
    }

    @Test
    void supplier() {
        // TODO - Convert this anonymous inner class to a lambda and then to a constructor reference
        var supplier = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new CopyOnWriteArrayList<String>();
            }
        };
        Assertions.assertThat(supplier.get()).isEqualTo(new CopyOnWriteArrayList<>());
        Assertions.assertThat(supplier.get()).isNotEqualTo(supplier.get());
        List<String> list = Stream.of("1", "2", "3").collect(Collectors.toCollection(supplier));
        Assertions.assertThat(list).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void biConsumer() {
        var result = new HashMap<String, String>();
        // TODO - Convert the anonymous inner class to a lambda
        var biConsumer = new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                result.put(key.toUpperCase(), value.toUpperCase());
            }
        };
        biConsumer.accept("a", "one");
        Assertions.assertThat(result).isEqualTo(Map.of("A", "ONE"));

        var lowercaseMap = Map.of("a", "one", "b", "two", "c", "three");
        lowercaseMap.forEach(biConsumer);
        Assertions.assertThat(result).isEqualTo(Map.of("A", "ONE", "B", "TWO", "C", "THREE"));
    }

    @Test
    void unaryOperator() {
        // TODO - Convert the anonymous inner class to a lambda
        var squared = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Assertions.assertThat(squared.apply(2)).isEqualTo(Integer.valueOf(4));
        Assertions.assertThat(squared.apply(3)).isEqualTo(Integer.valueOf(9));
        Assertions.assertThat(squared.apply(4)).isEqualTo(Integer.valueOf(16));

        // TODO - Convert the anonymous inner class to a lambda
        Assertions.assertThat(
                Stream.iterate(2, squared).anyMatch(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        return i.equals(Integer.valueOf(256));
                    }
                })).isTrue();
    }
}
