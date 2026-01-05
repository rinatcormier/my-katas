package my.rinat.horstmann.concurrency.base;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatesDemo {

    static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            int s = 0;
            for (int i = 0; i < 100_000; i++) {
                s = i;
            }
            System.out.println("Just a value " + s);
        };
        var thread = new Thread(task);
        System.out.println("Thread state is " + thread.getState());
        thread.start();
        System.out.println("Thread state is " + thread.getState());
        Runnable concurrentTask = () -> {
            var example = new ThreadStatesDemo();
            System.out.println("Before starting work...");
            int s = example.doSomeWork();
            System.out.println("Just a value " + s);
        };
        var acquiringLockThread = new Thread(concurrentTask);
        var waitingThread = new Thread(concurrentTask);
        acquiringLockThread.start();
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x = i + 1;
        }
        System.out.println("Just a value " + x);
        waitingThread.start();
        System.out.println("Acquiring lock thread state is " + acquiringLockThread.getState());
        // TODO: can't get BLOCKED state
        System.out.println("Waiting thread state is " + waitingThread.getState());
    }

    synchronized int doSomeWork() {
        int s = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            s = (i + ThreadLocalRandom.current().nextInt(10));
        }
        return s;
    }
}
