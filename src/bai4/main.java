package bai4;
import java.text.NumberFormat;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountName;
    private double balance;
    private String currency;
    private static final double INTEREST_RATE = 0.035;
    private static final double DEFAULT_AMOUNT = 50.0;

    public Account() {
        // Default constructor
    }

    public Account(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = DEFAULT_AMOUNT;
        this.currency = "USD"; // Default currency
    }

    public Account(String accountNumber, String accountName, double balance, String currency) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
    }

    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String formattedBalance = formatter.format(balance);
        return "Account Number: " + accountNumber + "\n" +
                "Account Name: " + accountName + "\n" +
                "Balance: " + formattedBalance + " " + currency;
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
            return false;
        }
        balance += amount;
        System.out.println("Deposit successful.");
        return false;
    }

    public boolean withdraw(double amount, double withdrawalFee) {
        double totalAmount = amount + withdrawalFee;
        if (totalAmount > balance) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
            return false;
        }
        balance -= totalAmount;
        System.out.println("Withdrawal successful.");
        return false;
    }

    public void maturity(double interestRate) {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Maturity successful.");
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount. Please enter a positive value.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
            return false;
        }
        balance -= amount;
        recipient.deposit(amount);
        System.out.println("Transfer successful.");
        return false;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create a new account with default values
            Account account1 = new Account();
            System.out.println("Account 1:\n" + account1);

            // Create a new account with account number, name, and balance
            System.out.print("Enter account number for account 2: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter account name for account 2: ");
            String accountName = scanner.nextLine();
            System.out.print("Enter initial balance for account 2: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            System.out.print("Enter currency code for account 2: ");
            String currency = scanner.nextLine();
            Account account2 = new Account(accountNumber, accountName, balance, currency);
            System.out.println("Account 2:\n" + account2);

            // Deposit into account 1
            System.out.print("Enter amount to deposit into account 1: ");
            double depositAmount = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            if (account1.deposit(depositAmount)) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
            System.out.println("Account 1 after deposit:\n" + account1);

            // Withdraw from account 2
            System.out.print("Enter amount to withdraw from account 2: ");
            double withdrawalAmount = scanner.nextDouble();
            System.out.print("Enter withdrawal fee for account 2: ");
            double withdrawalFee = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            if (account2.withdraw(withdrawalAmount, withdrawalFee)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
            System.out.println("Account 2 after withdrawal:\n" + account2);

            // Transfer from account 1 to account 2
            System.out.print("Enter amount to transfer from account 1 to account 2: ");
            double transferAmount = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            if (account1.transfer(account2, transferAmount)) {
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Invalid transfer amount.");
            }
            System.out.println("Account 1 after transfer:\n" + account1);
            System.out.println("Account 2 after transfer:\n" + account2);

            // Calculate interest on account 2
            double interestRate = Account.getInterestRate();
            double interest = account2.calculateInterest();
            System.out.println("Interest rate: " + interestRate);
            System.out.println("Interest earned: " + interest);
            account2.maturity(interestRate);
            System.out.println("Account 2 after maturity:\n" + account2);

            scanner.close();
        }
    }
}
