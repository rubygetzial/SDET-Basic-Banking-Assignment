import java.util.Scanner;

public class SavingsAccount extends Account {
    private double minimumBalance;
    private double penalty;
    
    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.minimumBalance = minimumBalance;
        this.penalty = 100; // Default penalty
    }
    
    // Method to set minimum balance dynamically
    public void setMinimumBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new minimum balance: ");
        double newMinBalance = scanner.nextDouble();
        
        if (newMinBalance >= 0) {
            this.minimumBalance = newMinBalance;
            System.out.println("✓ Minimum balance updated to: " + minimumBalance);
        } else {
            System.out.println("✗ Invalid minimum balance!");
        }
    }
    
    // Method to set penalty dynamically
    public void setPenalty() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter penalty amount: ");
        double newPenalty = scanner.nextDouble();
        
        if (newPenalty >= 0) {
            this.penalty = newPenalty;
            System.out.println("✓ Penalty updated to: " + penalty);
        } else {
            System.out.println("✗ Invalid penalty amount!");
        }
    }
    
    // Overridden method to calculate interest for Savings Account
    @Override
    public double calculateInterest() {
        // Savings account earns interest on the full balance
        return balance * (interestRate / 100);
    }
    
    // Overridden withdraw method with minimum balance check
    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✓ Withdrawn from Savings Account: " + amount);
            
            // Check if balance falls below minimum
            if (balance < minimumBalance) {
                balance -= penalty;
                System.out.println("⚠ Warning: Balance below minimum! Penalty of " + penalty + " applied.");
            }
            System.out.println("New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("✗ Insufficient balance! Your balance is: " + balance);
        } else {
            System.out.println("✗ Invalid amount!");
        }
    }
    
    // Override displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    SAVINGS ACCOUNT DETAILS             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Account Number: " + String.format("%-21s", accountNumber) + "║");
        System.out.println("║ Account Holder: " + String.format("%-21s", accountHolder) + "║");
        System.out.println("║ Balance: $" + String.format("%-30.2f", balance) + "║");
        System.out.println("║ Interest Rate: " + String.format("%-21.2f%%", interestRate) + "║");
        System.out.println("║ Minimum Balance: $" + String.format("%-25.2f", minimumBalance) + "║");
        System.out.println("║ Penalty: $" + String.format("%-32.2f", penalty) + "║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    // Getter and Setter
    public double getMinimumBalance() {
        return minimumBalance;
    }
    
    public double getPenalty() {
        return penalty;
    }
}