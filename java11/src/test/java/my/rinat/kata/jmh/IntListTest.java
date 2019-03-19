package my.rinat.kata.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a set of unit tests to validate the code is working as expected.
 */
class IntListTest {
    private List<Integer> jdkList;
    private IntList ecIntList;
    private MutableList<Integer> ecList;
    private ExecutorService executor;
    private long expectedSum;

    @BeforeEach
    void setUp() {
        this.executor = Executors.newWorkStealingPool();
        var iterator = new Random(1L).ints(-1000, 1000).iterator();
        this.ecList = FastList.newWithNValues(1_000_000, iterator::nextInt);
        this.jdkList = new ArrayList<>(1_000_000);
        this.jdkList.addAll(this.ecList);
        this.ecIntList = this.ecList.collectInt(i -> i, new IntArrayList(1_000_000));
        this.initializeExpectedSum();
    }

    void initializeExpectedSum() {
        this.expectedSum = 0;
        for (var integer : this.jdkList) {
            this.expectedSum += integer.longValue();
        }
    }

    @Test
    void sum() {
        Assertions.assertThat(this.jdkList.stream().mapToLong(i -> i).sum()).isEqualTo(this.expectedSum);
        Assertions.assertThat(this.jdkList.parallelStream().mapToLong(i -> i).sum()).isEqualTo(this.expectedSum);
        Assertions.assertThat(this.ecIntList.sum()).isEqualTo(this.expectedSum);
        Assertions.assertThat(this.ecList.sumOfInt(i -> i)).isEqualTo(this.expectedSum);
        Assertions.assertThat(this.ecList.asParallel(this.executor, 100_000).sumOfInt(i -> i)).isEqualTo(this.expectedSum);
    }

    @Test
    void filter() {
        Assertions.assertThat(this.ecList.select(i -> i % 2 == 0)).isEqualTo(this.jdkList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
        Assertions.assertThat(this.ecList.select(i -> i % 2 == 0).collectInt(Integer::intValue)).isEqualTo(this.ecIntList.select(i -> i % 2 == 0));
        Assertions.assertThat(this.ecList.asParallel(this.executor, 100_000).select(i -> i % 2 == 0).toList()).isEqualTo(this.jdkList.parallelStream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
    }

    @Test
    void transform() {
        Assertions.assertThat(this.ecList.collect(i -> i * 2).toList()).isEqualTo(this.jdkList.stream().mapToInt(i -> i * 2).boxed().collect(Collectors.toList()));
        Assertions.assertThat(this.ecList.collect(i -> i * 2).collectInt(Integer::intValue).toList()).isEqualTo(this.ecIntList.collectInt(i -> i * 2, IntLists.mutable.empty()));
        Assertions.assertThat(this.ecList.asParallel(this.executor, 100_000).collect(i -> i * 2).toList()).isEqualTo(this.jdkList.parallelStream().mapToInt(i -> i * 2).boxed().collect(Collectors.toList()));
    }
}
