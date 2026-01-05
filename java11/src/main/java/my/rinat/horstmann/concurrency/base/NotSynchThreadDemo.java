package my.rinat.horstmann.concurrency.base;

import my.rinat.horstmann.concurrency.bankdemo.NotThreadSafeBank;

/**
 * The race condition demo.
 */
public class NotSynchThreadDemo {

    static final int ACCOUNTS = 100;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 1000;
    static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new NotThreadSafeBank(ACCOUNTS, INITIAL_BALANCE);
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
