package my.rinat.horstmann.concurrency.bankdemo;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBank {

    private final double[] accounts;
    private final Lock bankLock;
    private final Condition sufficientFunds;

    public ConditionBank(int numberOfAccounts, double initialBalance) {
        this.accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
        this.bankLock = new ReentrantLock();
        this.sufficientFunds = bankLock.newCondition();
    }

    /**
     * Thread-safety of method ensured by condition variable (or object).
     */
    public void transfer(int fromAccount, int toAccount, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            System.out.printf("%s; ", Thread.currentThread());
            long counter = 0;
            while (accounts[fromAccount] < amount) {
                System.out.printf("%d ", ++counter);
                sufficientFunds.await();
            }
            accounts[fromAccount] -= amount;
            System.out.printf("%10.2f from %d to %d; ", amount, fromAccount, toAccount);
            accounts[toAccount] += amount;
            System.out.printf("Total Balance: %10.2f.%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }

    private double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
}
