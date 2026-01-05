package my.rinat.horstmann.concurrency.bankdemo;

import java.util.Arrays;

public class SynchronizedBlockBank {

    private final double[] accounts;

    public SynchronizedBlockBank(int numberOfAccounts, double initialBalance) {
        this.accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int fromAccount, int toAccount, double amount) throws InterruptedException {
        if (accounts[fromAccount] < amount) {
            System.out.printf("%s; Insufficient funds on account %d.%n", Thread.currentThread(), fromAccount);
            return;
        }
        synchronized (this) {
            System.out.printf("%s; ", Thread.currentThread());
            accounts[fromAccount] -= amount;
            System.out.printf("%10.2f from %d to %d; ", amount, fromAccount, toAccount);
            accounts[toAccount] += amount;
            System.out.printf("Total Balance: %10.2f.%n", getTotalBalance());
        }
    }

    public int size() {
        return accounts.length;
    }

    private double getTotalBalance() {
        synchronized (this) {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        }
    }
}
