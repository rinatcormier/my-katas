package my.rinat.kata.lambda.eclipsecollections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
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
class EclipseCollectionsFunctionalInterfaceTest {
    @Test
    void procedure() {
        var strings = Lists.mutable.with("one", "two", "three");

        // TODO - Can you remove the final keyword from the variable below?
        final var result = Lists.mutable.empty();

        // TODO - Convert the anonymous inner class to a lambda
        var procedure = new Procedure<String>() {
            @Override
            public void value(String each) {
                result.add(each.toUpperCase());
            }
        };
        procedure.accept("zero");
        Assertions.assertThat(result).isEqualTo(Lists.mutable.with("ZERO"));
        strings.each(procedure);
        Assertions.assertThat(result).isEqualTo(Lists.mutable.with("ZERO", "ONE", "TWO", "THREE"));
    }

    @Test
    void predicateIsEven() {
        var numbers = Interval.oneTo(10).toList();

        // TODO - Convert the anonymous inner class to a lambda
        var evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean accept(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Assertions.assertThat(evenPredicate.test(2)).isTrue();
        Assertions.assertThat(evenPredicate.test(1)).isFalse();
        MutableList<Integer> evens = numbers.select(evenPredicate);
        Assertions.assertThat(evens.allSatisfy(evenPredicate)).isTrue();
        Assertions.assertThat(evens.stream().allMatch(evenPredicate)).isTrue();
        Assertions.assertThat(evens.noneSatisfy(evenPredicate)).isFalse();
        Assertions.assertThat(evens.stream().noneMatch(evenPredicate)).isFalse();
        Assertions.assertThat(evens.anySatisfy(evenPredicate)).isTrue();
        Assertions.assertThat(evens.stream().anyMatch(evenPredicate)).isTrue();
        Assertions.assertThat(evens).isEqualTo(Interval.evensFromTo(1, 10));
    }

    @Test
    void predicateIsOdd() {
        var numbers = Interval.oneTo(10).toList();

        // TODO - Convert the anonymous inner class to a lambda
        var oddPredicate = new Predicate<Integer>() {
            @Override
            public boolean accept(Integer integer) {
                return integer % 2 == 1;
            }
        };
        Assertions.assertThat(oddPredicate.test(2)).isFalse();
        Assertions.assertThat(oddPredicate.test(1)).isTrue();
        MutableList<Integer> odds = numbers.select(oddPredicate);
        Assertions.assertThat(odds.allSatisfy(oddPredicate)).isTrue();
        Assertions.assertThat(odds.stream().allMatch(oddPredicate)).isTrue();
        Assertions.assertThat(odds.noneSatisfy(oddPredicate)).isFalse();
        Assertions.assertThat(odds.stream().noneMatch(oddPredicate)).isFalse();
        Assertions.assertThat(odds.stream().anyMatch(oddPredicate)).isTrue();
        Assertions.assertThat(odds.anySatisfy(oddPredicate)).isTrue();
        Assertions.assertThat(odds).isEqualTo(Interval.oddsFromTo(1, 10));
    }

    @Test
    void function() {
        // TODO - Convert the anonymous inner class to a lambda and then a method reference
        var toUppercase = new Function<String, String>() {
            @Override
            public String valueOf(String string) {
                return string.toUpperCase();
            }
        };
        Assertions.assertThat(toUppercase.apply("uppercase")).isEqualTo("UPPERCASE");
        MutableList<String> lowercase = Lists.mutable.with("a", "b", "c", "d");
        MutableList<String> uppercase = lowercase.collect(toUppercase);
        Assertions.assertThat(uppercase).isEqualTo(Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    void function0() {
        // TODO - Convert this anonymous inner class to a lambda and then to a constructor reference
        var supplier = new Function0<List<String>>() {
            @Override
            public List<String> value() {
                return FastList.newList();
            }
        };
        Assertions.assertThat(supplier.get()).isEqualTo(Lists.mutable.empty());
        Assertions.assertThat(supplier.get()).isNotEqualTo(supplier.get());
        List<String> list = Stream.of("1", "2", "3").collect(Collectors.toCollection(supplier));
        Assertions.assertThat(list).isEqualTo(Lists.mutable.with("1", "2", "3"));
    }

    @Test
    void procedure2() {
        var result = Maps.mutable.empty();
        // TODO - Convert the anonymous inner class to a lambda
        var procedure2 = new Procedure2<String, String>() {
            @Override
            public void value(String key, String value) {
                result.put(key.toUpperCase(), value.toUpperCase());
            }
        };
        procedure2.accept("a", "one");
        Assertions.assertThat((Map<Object, Object>) result).isEqualTo(Maps.mutable.with("A", "ONE"));
        Maps.mutable.with("b", "two", "c", "three").forEachKeyValue(procedure2);
        Assertions.assertThat((Map<Object, Object>) result).isEqualTo(Maps.mutable.with("A", "ONE", "B", "TWO", "C", "THREE"));
    }
}
