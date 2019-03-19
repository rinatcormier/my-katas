package my.rinat.kata.lambda.eclipsecollections;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.junit.jupiter.api.Test;

class EclipseCollectionsPrimitiveFunctionalInterfaceTest {
    @Test
    void IntProcedure() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var procedure = new IntProcedure() {
            @Override
            public void value(int value) {
                adder.add((long) value);
            }
        };
        IntInterval.oneTo(5).forEach(procedure);
        Assertions.assertThat(adder.longValue()).isEqualTo(15);
    }

    @Test
    void LongProcedure() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var procedure = new LongProcedure() {
            @Override
            public void value(long value) {
                adder.add(value);
            }
        };
        LongLists.mutable.with(1, 2, 3, 4, 5).forEach(procedure);
        Assertions.assertThat(adder.longValue()).isEqualTo(15);
    }

    @Test
    void DoubleProcedure() {
        var adder = new DoubleAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var procedure = new DoubleProcedure() {
            @Override
            public void value(double value) {
                adder.add(value);
            }
        };
        DoubleLists.mutable.with(1.0d, 2.0d, 3.0d, 4.0d, 5.0d).forEach(procedure);
        Assertions.assertThat(adder.doubleValue()).isEqualTo(15.0, Assertions.within(0.0));
    }

    @Test
    void IntPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new IntPredicate() {
            @Override
            public boolean accept(int value) {
                return value % 2 == 0;
            }
        };
        IntInterval interval = IntInterval.oneTo(5);
        ImmutableIntList evens = interval.select(predicate);
        Assertions.assertThat(evens).isEqualTo(IntLists.mutable.with(2, 4));
        Assertions.assertThat(evens).isEqualTo(IntInterval.evensFromTo(1, 5));
        ImmutableIntList odds = interval.reject(predicate);
        Assertions.assertThat(odds).isEqualTo(IntLists.mutable.with(1, 3, 5));
        Assertions.assertThat(odds).isEqualTo(IntInterval.oddsFromTo(1, 5));
        Assertions.assertThat(interval.anySatisfy(predicate)).isTrue();
        Assertions.assertThat(interval.allSatisfy(predicate)).isFalse();
        Assertions.assertThat(interval.noneSatisfy(predicate)).isFalse();
        Assertions.assertThat(IntStream.rangeClosed(1, 5).anyMatch(predicate)).isTrue();
        Assertions.assertThat(IntStream.rangeClosed(1, 5).allMatch(predicate)).isFalse();
        Assertions.assertThat(IntStream.rangeClosed(1, 5).noneMatch(predicate)).isFalse();
    }

    @Test
    void LongPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new LongPredicate() {
            @Override
            public boolean accept(long value) {
                return value % 2 == 0;
            }
        };
        var list = LongLists.mutable.with(1, 2, 3, 4, 5);
        var evens = list.select(predicate);
        Assertions.assertThat(evens).isEqualTo(LongLists.mutable.with(2, 4));
        var odds = list.reject(predicate);
        Assertions.assertThat(odds).isEqualTo(LongLists.mutable.with(1, 3, 5));
        Assertions.assertThat(list.anySatisfy(predicate)).isTrue();
        Assertions.assertThat(list.allSatisfy(predicate)).isFalse();
        Assertions.assertThat(list.noneSatisfy(predicate)).isFalse();
        Assertions.assertThat(LongStream.rangeClosed(1, 5).anyMatch(predicate)).isTrue();
        Assertions.assertThat(LongStream.rangeClosed(1, 5).allMatch(predicate)).isFalse();
        Assertions.assertThat(LongStream.rangeClosed(1, 5).noneMatch(predicate)).isFalse();
    }

    @Test
    void DoublePredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new DoublePredicate() {
            @Override
            public boolean accept(double value) {
                return value > 3.0;
            }
        };
        var list = DoubleLists.mutable.with(1.0, 2.0, 3.0, 4.0, 5.0);
        var greaterThan = list.select(predicate);
        Assertions.assertThat(greaterThan).isEqualTo(DoubleLists.mutable.with(4.0d, 5.0d));
        var lessThanEqualTo = list.reject(predicate);
        Assertions.assertThat(lessThanEqualTo).isEqualTo(DoubleLists.mutable.with(1.0d, 2.0d, 3.0d));
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).anyMatch(predicate)).isTrue();
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).allMatch(predicate)).isFalse();
        Assertions.assertThat(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).noneMatch(predicate)).isFalse();
    }
}
