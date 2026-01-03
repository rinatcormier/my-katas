package my.rinat.horstmann.concurrency.base;

import my.rinat.horstmann.concurrency.util.NotThreadSafeBank;

class SimpleThreadDemo {

    static final int DELAY = 10;
    static final int STEPS = 100;
    static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        var bank = new NotThreadSafeBank(4, 100_000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        };
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
