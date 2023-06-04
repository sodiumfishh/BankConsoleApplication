import java.util.Scanner;

public class BankMenu {
    private Scanner scanner;
    private Bank bank;

    public BankMenu() {
        scanner = new Scanner(System.in);
        bank = new Bank();
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Welcome to the Bank!");
            System.out.println("1. Create Account");
            System.out.println("2. Account Operations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccountMenu();
                    break;
                case 2:
                    accountOperationsMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using the Bank!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    private void createAccountMenu() {
        int choice;
        do {
            System.out.println("Create Account Menu");
            System.out.println("1. Savings Account");
            System.out.println("2. Checking Account");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createSavingsAccount();
                    break;
                case 2:
                    createCheckingAccount();
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    private void createSavingsAccount() {
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(balance, interestRate);
        bank.addAccount(account);

        System.out.println("Savings Account created successfully! Account Number: " + account.getAccountNumber());
        System.out.println("-----------------------------------");
    }

    private void createCheckingAccount() {
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = scanner.nextDouble();

        CheckingAccount account = new CheckingAccount(balance, overdraftLimit);
        bank.addAccount(account);

        System.out.println("Checking Account created successfully! Account Number: " + account.getAccountNumber());
        System.out.println("------------------------------------");
    }



    private void accountOperationsMenu() {
        int choice;
        do {
            System.out.println("Account Operations Menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Details");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    displayAccountDetails();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    private void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        bank.deposit(accountNumber, amount);
        System.out.println("Deposit successful!");
        System.out.println("------------------");
    }

    private void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        bank.withdraw(accountNumber, amount);
        System.out.println("Withdrawal successful!");
        System.out.println("---------------------");
    }

    private void displayAccountDetails() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Details:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
        System.out.println("----------------");
    }
}
