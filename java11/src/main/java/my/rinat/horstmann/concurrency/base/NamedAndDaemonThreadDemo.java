package my.rinat.horstmann.concurrency.base;

public class NamedAndDaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            //noinspection InfiniteLoopStatement
            while (true) {
                System.out.println("Name of the daemon thread is '" + Thread.currentThread().getName() + "'");
            }
        };
        var thread = new Thread(task);
        thread.setName("Infinite thread");
        thread.setDaemon(true); // should be called before start
        // the main app doesn't wait for finishing of daemon threads
        thread.start();
        Thread.sleep(10);
        System.out.println("The main thread is finished");
    }
}
