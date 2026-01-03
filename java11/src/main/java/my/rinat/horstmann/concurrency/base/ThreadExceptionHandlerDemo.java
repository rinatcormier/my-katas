package my.rinat.horstmann.concurrency.base;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadExceptionHandlerDemo {
    public static void main(String[] args) throws InterruptedException {
        UncaughtExceptionHandler individualExceptionHandler = (thread, exception) -> {
            System.out.printf("There was an exception '%s' in thread '%s'%n", exception.getMessage(), thread);
        };
        Runnable task = () -> {
            var isException = ThreadLocalRandom.current().nextBoolean();
            if (isException) {
                throw new RuntimeException("Unpredictable exception");
            }
            System.out.println("Task completed successfully!");
        };
        var thread1 = new Thread(task); // thread with individual exception handler
        thread1.setName("UncaughtExceptionDemo1");
        thread1.setUncaughtExceptionHandler(individualExceptionHandler);
        thread1.start();
        var thread2 = new Thread(task); // thread without exception handler (handles by ThreadGroup)
        thread2.setName("UncaughtExceptionDemo2");
        thread2.start();
        Thread.sleep(10);
        UncaughtExceptionHandler commonExceptionHandler = (thread, exception) -> {
            System.out.printf("Common exception '%s' in thread '%s'%n", exception.getMessage(), thread);
        };
        Thread.setDefaultUncaughtExceptionHandler(commonExceptionHandler);
        var thread3 = new Thread(task); // thread with common default exception handler
        thread3.setName("UncaughtExceptionDemo3");
        thread3.start();
    }
}
