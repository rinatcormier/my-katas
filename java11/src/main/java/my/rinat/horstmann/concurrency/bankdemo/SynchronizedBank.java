package my.rinat.horstmann.concurrency.bankdemo;

import java.util.Arrays;

public class SynchronizedBank {

    private final double[] accounts;

    public SynchronizedBank(int numberOfAccounts, double initialBalance) {
        this.accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int fromAccount, int toAccount, double amount) throws InterruptedException {
        System.out.printf("%s; ", Thread.currentThread());
        long counter = 0;
        while (accounts[fromAccount] < amount) {
            System.out.printf("%d ", ++counter); // just for tracing
            wait();
        }
        accounts[fromAccount] -= amount;
        System.out.printf("%10.2f from %d to %d; ", amount, fromAccount, toAccount);
        accounts[toAccount] += amount;
        System.out.printf("Total Balance: %10.2f.%n", getTotalBalance());
        notifyAll();
    }

    public int size() {
        return accounts.length;
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }
}
