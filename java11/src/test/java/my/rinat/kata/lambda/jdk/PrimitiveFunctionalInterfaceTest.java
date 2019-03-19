package my.rinat.kata.lambda.jdk;

import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimitiveFunctionalInterfaceTest {
    @Test
    void IntConsumer() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                adder.add((long) value);
            }
        };
        IntStream.rangeClosed(1, 5).forEach(consumer);
        Assertions.assertThat(adder.longValue()).isEqualTo(15);
    }

    @Test
    void LongConsumer() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new LongConsumer() {
            @Override
            public void accept(long value) {
                adder.add(value);
            }
        };
        LongStream.rangeClosed(1, 5).forEach(consumer);
        Assertions.assertThat(adder.longValue()).isEqualTo(15);
    }

    @Test
    void DoubleConsumer() {
        var adder = new DoubleAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {
                adder.add(value);
            }
        };
        DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).forEach(consumer);
        Assertions.assertThat(adder.doubleValue()).isEqualTo(15.0, Assertions.within(0.0));
    }

    @Test
    void IntPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        };
        var evens = IntStream.rangeClosed(1, 5).filter(predicate).boxed().collect(Collectors.toList());
        Assertions.assertThat(Arrays.asList(2, 4)).isEqualTo(evens);
        var odds = IntStream.rangeClosed(1, 5).filter(predicate.negate()).boxed().collect(Collectors.toList());
        Assertions.assertThat(Arrays.asList(1, 3, 5)).isEqualTo(odds);
        Assertions.assertThat(IntStream.rangeClosed(1, 5).anyMatch(predicate)).isTrue();
        Assertions.assertThat(IntStream.rangeClosed(1, 5).allMatch(predicate)).isFalse();
        Assertions.assertThat(IntStream.rangeClosed(1, 5).noneMatch(predicate)).isFalse();
    }

    @Test
    void LongPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new LongPredicate() {
            @Override
            public boolean test(long value) {
                return value % 2 == 0;
            }
        };
        var evens = LongStream.rangeClosed(1, 5).filter(predicate).boxed().collect(Collectors.toList());
        Assertions.assertThat(Arrays.asList(2L, 4L)).isEqualTo(evens);
        var odds = LongStream.rangeClosed(1, 5).filter(predicate.negate()).boxed().collect(Collectors.toList());
        Assertions.assertThat(Arrays.asList(1L, 3L, 5L)).isEqualTo(odds);
        Assertions.assertThat(LongStream.rangeClosed(1, 5).anyMatch(predicate)).isTrue();
        Assertions.assertThat(LongStream.rangeClosed(1, 5).allMatch(predicate)).isFalse();
        Assertions.assertThat(LongStream.rangeClosed(1, 5).noneMatch(predicate)).isFalse();
    }

    @Test
    void DoublePredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new DoublePredicate() {
            @Override
            public boolean test(double value) {
                return value > 3.0;
            }
        };
        var greaterThan =
                DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).filter(predicate).boxed().collect(Collectors.toList());
        Assertions.assertThat(Arrays.asList(4.0d, 5.0d)).isEqualTo(greaterThan);

        var lessThanEqualTo =
                DoubleStream
                        .of(1.0, 2.0, 3.0, 4.0, 5.0)
                        .filter(predicate.negate())
                        .boxed()
                        .collect(Collectors.toList());

        Assertions.assertThat(Arrays.asList(1.0d, 2.0d, 3.0d)).isEqualTo(lessThanEqualTo);
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).anyMatch(predicate)).isTrue();
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).allMatch(predicate)).isFalse();
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).noneMatch(predicate)).isFalse();
    }
}
