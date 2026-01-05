package my.rinat.horstmann.concurrency.base;

import my.rinat.horstmann.concurrency.bankdemo.SynchronizedBank;

public class SynchronizedThreadDemo {

    static final int ACCOUNTS = 100_000;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 100; // if value greater than or equal to 1000 then deadlock occurs eventually
                                          // due to all threads go to wait set when reach condition variable
                                          // TODO: reproduce deadlock and use diagnostic tools to determine it
    static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new SynchronizedBank(ACCOUNTS, INITIAL_BALANCE);
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
