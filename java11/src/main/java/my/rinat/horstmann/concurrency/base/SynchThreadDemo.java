package my.rinat.horstmann.concurrency.base;

import my.rinat.horstmann.concurrency.bankdemo.ThreadSafeBank;

/**
 * Synchronized by locks demo.
 */
public class SynchThreadDemo {

    static final int ACCOUNTS = 10;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 1000;
    static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new ThreadSafeBank(ACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < ACCOUNTS; i++) {
            int fromAccount = i;
            Runnable task = () -> {
                try {
                    //noinspection InfiniteLoopStatement
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        //noinspection BusyWait
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException ignore) {
                }
            };
            var thread = new Thread(task);
            thread.start();
        }
    }
}
