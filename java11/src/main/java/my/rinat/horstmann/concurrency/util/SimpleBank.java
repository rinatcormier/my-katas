package my.rinat.horstmann.concurrency.util;

import java.util.Arrays;

public class SimpleBank {

    private final double[] accounts;

    public SimpleBank(int numberOfAccounts, double initialBalance) {
        accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Not thread-safe method.
     */
    public void transfer(int fromAccount, int toAccount, double amount) {
        System.out.printf("%s; ", Thread.currentThread());
        if (accounts[fromAccount] < amount) {
            System.out.printf("Insufficient funds on account %d.%n", fromAccount);
            return;
        }
        accounts[fromAccount] -= amount;
        System.out.printf("%10.2f from %d to %d; ", amount, fromAccount, toAccount);
        accounts[toAccount] += amount;
        System.out.printf("Total Balance: %10.2f.%n", getTotalBalance());
    }

    private double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }
}
