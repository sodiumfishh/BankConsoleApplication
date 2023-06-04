import java.util.Random;

public abstract class Account {
    private static Random random = new Random();

    private int accountNumber;
    private double balance;

    public Account(double balance) {
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
    }

    private int generateAccountNumber() {
        return random.nextInt(9000) + 1000;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract void withdraw(double amount);
}
