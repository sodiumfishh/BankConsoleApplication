public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            double balance = getBalance() - amount;
            // Additional logic specific to checking account
            // e.g., charge overdraft fee if applicable
            setBalance(balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
