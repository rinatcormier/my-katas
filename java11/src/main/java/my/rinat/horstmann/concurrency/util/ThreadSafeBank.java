package my.rinat.horstmann.concurrency.util;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBank {

    private final double[] accounts;
    private final Lock bankLock = new ReentrantLock();

    public ThreadSafeBank(int numberOfAccounts, double initialBalance) {
        accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Thread-safe method.
     */
    public void transfer(int fromAccount, int toAccount, double amount) {
        System.out.printf("%s; ", Thread.currentThread());
        if (accounts[fromAccount] < amount) {
            System.out.printf("Insufficient funds on account %d.%n", fromAccount);
            return;
        }
        // the basic outline for protecting a code block with a ReentrantLock:
        bankLock.lock();
        try {
            accounts[fromAccount] -= amount;
            System.out.printf("%10.2f from %d to %d; ", amount, fromAccount, toAccount);
            accounts[toAccount] += amount;
            System.out.printf("Total Balance: %10.2f.%n", getTotalBalance());
        } finally {
            bankLock.unlock(); // make sure the lock is unlocked even if an exception is thrown
            // CAUTION: Be careful to ensure that the code in a critical section is not bypassed
            // by throwing an exception. If an exception is thrown before the end of the section,
            // the `finally` clause will relinquish the lock, but the object may be in a damaged state.
        }
    }

    public int size() {
        return accounts.length;
    }

    private double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }
}
