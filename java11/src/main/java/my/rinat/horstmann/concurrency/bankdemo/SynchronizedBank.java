package my.rinat.horstmann.concurrency.bankdemo;

import java.util.Arrays;

public class SynchronizedBank {

    private final double[] accounts;

    public SynchronizedBank(int numberOfAccounts, double initialBalance) {
        this.accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int fromAccount, int toAccount, double amount) throws InterruptedException {
        double f = accounts[fromAccount];
        double t = accounts[toAccount];
        while (accounts[fromAccount] < amount) {
            System.out.printf("%s; ", Thread.currentThread());
            System.out.printf("Insufficient: %10.2f from %d[%.2f] to %d[%.2f]%n", amount, fromAccount, f, toAccount, t);
            wait();
        }
        accounts[fromAccount] -= amount;
        System.out.printf("%s; ", Thread.currentThread());
        System.out.printf("%10.2f from %d[%.2f] to %d[%.2f]; ", amount, fromAccount, f, toAccount, t);
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
