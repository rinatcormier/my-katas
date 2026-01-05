package my.rinat.horstmann.concurrency.base;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicsDemo {

    static final int THREADS = 1000;

    public static void main(String[] args) {
        var atomicLong = new AtomicLong(0); // inefficient for huge number of threads in comparison with
        var longAdder = new LongAdder();    // LongAdder or LongAccumulator
        var longAccumulator = new LongAccumulator(Math::min, ThreadLocalRandom.current().nextLong());
        for (int i = 0; i < THREADS; i++) {
            Runnable task = () -> {
                var v = atomicLong.incrementAndGet();
                var m = atomicLong.updateAndGet(x -> Math.max(x, ThreadLocalRandom.current().nextLong(v)));
                var a = atomicLong.accumulateAndGet(ThreadLocalRandom.current().nextLong(m), Math::max);
                longAdder.increment();
                longAdder.add(ThreadLocalRandom.current().nextLong(a));
                longAccumulator.accumulate(ThreadLocalRandom.current().nextLong(a));
            };
            var thread = new Thread(task);
            thread.start();
        }
        System.out.println(atomicLong.get() + longAdder.sum() + longAccumulator.get());
    }
}
