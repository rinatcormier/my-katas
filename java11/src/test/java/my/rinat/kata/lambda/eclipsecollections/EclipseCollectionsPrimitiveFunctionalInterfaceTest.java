package my.rinat.kata.lambda.eclipsecollections;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
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
        // fixme:
        // Assert.assertEquals(15, adder.longValue());
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
        // fixme:
        // Assert.assertEquals(15, adder.longValue());
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
        // fixme:
        // Assert.assertEquals(15.0, adder.doubleValue(), 0.0);
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
        /*
        fixme:
        Assert.assertEquals(IntLists.mutable.with(2, 4), evens);
        Assert.assertEquals(IntInterval.evensFromTo(1, 5), evens);*/
        ImmutableIntList odds = interval.reject(predicate);
        /*
        fixme:
        Assert.assertEquals(IntLists.mutable.with(1, 3, 5), odds);
        Assert.assertEquals(IntInterval.oddsFromTo(1, 5), odds);
        Assert.assertTrue(interval.anySatisfy(predicate));
        Assert.assertFalse(interval.allSatisfy(predicate));
        Assert.assertFalse(interval.noneSatisfy(predicate));
        Assert.assertTrue(IntStream.rangeClosed(1, 5).anyMatch(predicate));
        Assert.assertFalse(IntStream.rangeClosed(1, 5).allMatch(predicate));
        Assert.assertFalse(IntStream.rangeClosed(1, 5).noneMatch(predicate));*/
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
        // fixme:
        // Assert.assertEquals(LongLists.mutable.with(2, 4), evens);
        var odds = list.reject(predicate);
        /*
        fixme:
        Assert.assertEquals(LongLists.mutable.with(1, 3, 5), odds);
        Assert.assertTrue(list.anySatisfy(predicate));
        Assert.assertFalse(list.allSatisfy(predicate));
        Assert.assertFalse(list.noneSatisfy(predicate));
        Assert.assertTrue(LongStream.rangeClosed(1, 5).anyMatch(predicate));
        Assert.assertFalse(LongStream.rangeClosed(1, 5).allMatch(predicate));
        Assert.assertFalse(LongStream.rangeClosed(1, 5).noneMatch(predicate));*/
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
        // fixme:
        // Assert.assertEquals(DoubleLists.mutable.with(4.0d, 5.0d), greaterThan);
        var lessThanEqualTo = list.reject(predicate);
        /*
        fixme:
        Assert.assertEquals(DoubleLists.mutable.with(1.0d, 2.0d, 3.0d), lessThanEqualTo);
        Assert.assertTrue(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).anyMatch(predicate));
        Assert.assertFalse(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).allMatch(predicate));
        Assert.assertFalse(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).noneMatch(predicate));*/
    }
}
