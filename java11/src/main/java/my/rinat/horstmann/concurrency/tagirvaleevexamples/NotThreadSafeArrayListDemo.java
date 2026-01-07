package my.rinat.horstmann.concurrency.tagirvaleevexamples;

import java.util.ArrayList;
import java.util.List;

import static my.rinat.horstmann.concurrency.tagirvaleevexamples.StaticListContainer.list;

public class NotThreadSafeArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            var container = new StaticListContainer();
            for (int i = 0; i < 100_000; i++) {
                /*
                 * ArrayList isn't thread-safe hence using it at multithreaded environment
                 * from many container instances can cause corrupting data or throwing exceptions.
                 */
                container.addEntry(i);
            }
        };
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(task1);
            thread.start();
            threads.add(thread);
        }
        for (var thread : threads) {
            thread.join();
        }
        System.out.println(list.size()); // size is not 1_000_000
        System.out.println("----------");
        var container = new StaticListContainer();
        list.clear();
        Runnable task2 = () -> {
            for (int i = 0; i < 100_000; i++) {
                /*
                 * addEntry method is synchronized and there used one container instance
                 * hence adding items at multithreaded environment has to be correct
                 */
                container.addEntry(i);
            }
        };
        threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(task2);
            thread.start();
            threads.add(thread);
        }
        for (var thread : threads) {
            thread.join();
        }
        System.out.println(list.size()); // size is 1_000_000
        System.out.println("----------");
        var instanceContainer = new InstanceListContainer();
        Runnable task3 = () -> {
            for (int i = 0; i < 100_000; i++) {
                instanceContainer.addEntry(i);
            }
        };
        threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(task3);
            thread.start();
            threads.add(thread);
        }
        /*
         * Due to size() method isn't synchronized java compiler
         * can optimize this part of code like this:
         *
         * int size$0 = container.list.size;
         * if (size$0 < 1000000) {
         *   while (true) {}
         * }
         *
         * hence this program hangs up.
         * To fix this it's enough to make size() method synchronized.
         */
        //noinspection StatementWithEmptyBody
        while (instanceContainer.size() < 1_000_000) {
        }
        System.out.println("Finish");

    }
}

class StaticListContainer {

    public static final List<Integer> list = new ArrayList<>();

    synchronized void addEntry(Integer value) {
        list.add(value);
    }
}

class InstanceListContainer {

    private final List<Integer> list = new ArrayList<>();

    synchronized void addEntry(Integer value) {
        list.add(value);
    }

    int size() {
        return list.size();
    }
}