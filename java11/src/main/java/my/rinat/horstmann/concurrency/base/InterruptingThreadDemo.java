package my.rinat.horstmann.concurrency.base;

public class InterruptingThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable interruptDemo1 = () -> {
            long s = 0;
            System.out.println("Job1 started...");
            while (!Thread.currentThread().isInterrupted() && s < 999_000_000_000L) {
                // if thread will be blocked or slept it can't check the interrupted status
                s++;
            }
            System.out.println("Job1 completed with s equals to " + s);
        };
        var thread = new Thread(interruptDemo1);
        thread.start();
        System.out.println("Is thread interrupted? " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("And now? " + thread.isInterrupted());

        Thread.sleep(1000);
        System.out.println("-------------------------");

        Runnable interruptDemo2 = () -> {
            System.out.println("Job2 started...");
            try {
                // no need to call isInterrupted when thread is sleeping or waiting 'cause it will always be interrupted
                Thread.sleep(10_000);
            } catch (InterruptedException ex) {
                System.out.println("Job2 was interrupted during a sleep...");
            }
        };
        var oneMoreThread = new Thread(interruptDemo2);
        oneMoreThread.start();
        System.out.println("Is thread interrupted? " + oneMoreThread.isInterrupted());
        oneMoreThread.interrupt();
        System.out.println("And now? " + oneMoreThread.isInterrupted());
    }
}
