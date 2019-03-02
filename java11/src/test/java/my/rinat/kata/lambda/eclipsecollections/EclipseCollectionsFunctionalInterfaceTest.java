package my.rinat.kata.lambda.eclipsecollections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        // fixme:
        // Assert.assertEquals(Lists.mutable.with("ZERO"), result);
        strings.each(procedure);
        // fixme:
        // Assert.assertEquals(Lists.mutable.with("ZERO", "ONE", "TWO", "THREE"), result);
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
        // fixme:
        // Assert.assertTrue(evenPredicate.test(2));
        // Assert.assertFalse(evenPredicate.test(1));
        MutableList<Integer> evens = numbers.select(evenPredicate);
        // fixme:
        // Assert.assertTrue(evens.allSatisfy(evenPredicate));
        // Assert.assertTrue(evens.stream().allMatch(evenPredicate));
        // Assert.assertFalse(evens.noneSatisfy(evenPredicate));
        // Assert.assertFalse(evens.stream().noneMatch(evenPredicate));
        // Assert.assertTrue(evens.anySatisfy(evenPredicate));
        // Assert.assertTrue(evens.stream().anyMatch(evenPredicate));
        // Assert.assertEquals(Interval.evensFromTo(1, 10), evens);
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
        // fixme:
        // Assert.assertFalse(oddPredicate.test(2));
        // Assert.assertTrue(oddPredicate.test(1));
        MutableList<Integer> odds = numbers.select(oddPredicate);
        // fixme:
        // Assert.assertTrue(odds.allSatisfy(oddPredicate));
        // Assert.assertTrue(odds.stream().allMatch(oddPredicate));
        // Assert.assertFalse(odds.noneSatisfy(oddPredicate));
        // Assert.assertFalse(odds.stream().noneMatch(oddPredicate));
        // Assert.assertTrue(odds.stream().anyMatch(oddPredicate));
        // Assert.assertTrue(odds.anySatisfy(oddPredicate));
        // Assert.assertEquals(Interval.oddsFromTo(1, 10), odds);
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
        // fixme:
        // Assert.assertEquals("UPPERCASE", toUppercase.apply("uppercase"));
        MutableList<String> lowercase = Lists.mutable.with("a", "b", "c", "d");
        MutableList<String> uppercase = lowercase.collect(toUppercase);
        // fixme:
        // Assert.assertEquals(Arrays.asList("A", "B", "C", "D"), uppercase);
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
        // fixme:
        // Assert.assertEquals(Lists.mutable.empty(), supplier.get());
        // Assert.assertNotSame(supplier.get(), supplier.get());
        List<String> list = Stream.of("1", "2", "3").collect(Collectors.toCollection(supplier));
        // fixme:
        // Assert.assertEquals(Lists.mutable.with("1", "2", "3"), list);
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
        // fixme:
        // Assert.assertEquals(Maps.mutable.with("A", "ONE"), result);
        Maps.mutable.with("b", "two", "c", "three").forEachKeyValue(procedure2);
        // fixme:
        // Assert.assertEquals(Maps.mutable.with("A", "ONE", "B", "TWO", "C", "THREE"), result);
    }
}
