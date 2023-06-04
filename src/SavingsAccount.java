public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            double balance = getBalance() - amount;
            // Additional logic specific to savings account
            // e.g., check if minimum balance is maintained
            setBalance(balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
