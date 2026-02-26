import java.util.Scanner;

public abstract class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected double interestRate;
    
    // Constructor
    public Account(String accountNumber, String accountHolder, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    
    // Method to deposit money with dynamic input
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("✗ Invalid amount! Amount must be greater than 0");
        }
    }
    
    // Method to withdraw money with dynamic input
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✓ Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("✗ Insufficient balance! Your balance is: " + balance);
        } else {
            System.out.println("✗ Invalid amount! Amount must be greater than 0");
        }
    }
    
    // Method to set interest rate dynamically
    public void setInterestRate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new interest rate (%): ");
        double newRate = scanner.nextDouble();
        
        if (newRate >= 0) {
            this.interestRate = newRate;
            System.out.println("✓ Interest rate updated to: " + interestRate + "%");
        } else {
            System.out.println("✗ Invalid interest rate! Must be 0 or greater");
        }
    }
    
    // Abstract method to calculate interest
    public abstract double calculateInterest();
    
    // Method to add interest to account with dynamic interest rate
    public void addInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("✓ Interest added: " + interest);
        System.out.println("New Balance: " + balance);
    }
    
    // Method to get balance
    public double getBalance() {
        return balance;
    }
    
    // Method to display account details
    public abstract void displayAccountDetails();
    
    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
}