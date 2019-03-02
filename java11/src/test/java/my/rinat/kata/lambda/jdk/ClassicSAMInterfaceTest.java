package my.rinat.kata.lambda.jdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.collections.impl.list.Interval;
import org.junit.jupiter.api.Test;

/**
 * This test will illustrate how you can use lambdas with older JDK Single Abstract Method types
 * like Comparator, Runnable and Callable.
 * <p>
 * Please refer to this tutorial for an overview of Lambdas for Java 8.
 *
 * @see <a href="http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html">Lambda Quickstart</a>
 * <p>
 * Then follow the TODOs in each test and convert the anonymous inner classes to lambdas and/or method references.
 */
class ClassicSAMInterfaceTest {
    @Test
    void comparator() {
        // TODO - Convert the comparator to a lambda and then to a method reference
        var comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                return one.compareTo(two);
            }
        };
        // fixme:
        // Assert.assertEquals(0, comparator.compare(1, 1));
//        Assert.assertEquals(-1, comparator.compare(1, 2));
//        Assert.assertEquals(1, comparator.compare(3, 2));

        var integers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        Collections.shuffle(integers);
        integers.sort(comparator);

        // fixme:
        // Assert.assertEquals(List.of(1, 2, 3, 4, 5), integers);
    }

    @Test
    void runnable() {
        // Note: The following list reference is "effectively" final, which is a new feature in Java 8
        var list = new ArrayList<Integer>();
        // TODO - convert the anonymous Inner class to a lambda
        var runnable = new Runnable() {
            @Override
            public void run() {
                list.add(1);
            }
        };
        runnable.run();
        // fixme:
        // Assert.assertEquals(List.of(1), list);
        // TODO - convert the anonymous Inner class to a lambda
        Interval.fromTo(2, 10).run(new Runnable() {
            @Override
            public void run() {
                list.add(1);
            }
        });
        var expectedList = Collections.nCopies(10, 1);
        // fixme:
        // Assert.assertEquals(expectedList, list);
    }

    @Test
    void callable() throws Exception {
        // Note: The following set references is "effectively" final, which is a new feature in Java 8
        var set = new HashSet<Integer>();
        // TODO - convert the anonymous inner class to lambda
        var callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return set.add(1);
            }
        };
        // fixme:
        // Assert.assertTrue(callable.call());
//        Assert.assertEquals(Set.of(1), set);

        var executor = Executors.newWorkStealingPool();
        var futures = executor.invokeAll(Collections.nCopies(5, callable));

        // Note: Functions.throwing() is a utility method in Eclipse Collections without which we would
        // have to wrap the call to Future.get() in a try-catch block.
        // fixme:
        // Assert.assertTrue(futures.stream().map(Functions.throwing(Future::get)).noneMatch(b -> b));
//        Assert.assertEquals(Set.of(1), set);
    }
}
