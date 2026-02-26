import java.util.Scanner;

public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double overdraftCharge;
    
    // Constructor
    public CurrentAccount(String accountNumber, String accountHolder, double balance, double interestRate, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.overdraftLimit = overdraftLimit;
        this.overdraftCharge = 50; // Default charge
    }
    
    // Method to set overdraft limit dynamically
    public void setOverdraftLimit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new overdraft limit: ");
        double newLimit = scanner.nextDouble();
        
        if (newLimit >= 0) {
            this.overdraftLimit = newLimit;
            System.out.println("✓ Overdraft limit updated to: " + overdraftLimit);
        } else {
            System.out.println("✗ Invalid overdraft limit!");
        }
    }
    
    // Method to set overdraft charge dynamically
    public void setOverdraftCharge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter overdraft charge amount: ");
        double newCharge = scanner.nextDouble();
        
        if (newCharge >= 0) {
            this.overdraftCharge = newCharge;
            System.out.println("✓ Overdraft charge updated to: " + overdraftCharge);
        } else {
            System.out.println("✗ Invalid charge amount!");
        }
    }
    
    // Overridden method to calculate interest for Current Account
    @Override
    public double calculateInterest() {
        // Current account may have minimal or no interest
        // Only earns interest if balance is positive
        if (balance > 0) {
            return balance * (interestRate / 100);
        }
        return 0;
    }
    
    // Overridden withdraw method with overdraft facility
    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        double availableFunds = balance + overdraftLimit;
        
        if (amount > 0 && amount <= availableFunds) {
            balance -= amount;
            System.out.println("✓ Withdrawn from Current Account: " + amount);
            
            // Check if overdraft is used
            if (balance < 0) {
                balance -= overdraftCharge;
                System.out.println("⚠ Warning: Overdraft used! Charge of " + overdraftCharge + " applied.");
                System.out.println("Overdraft Amount Used: " + Math.abs(balance + overdraftCharge));
            }
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("✗ Withdrawal exceeds available funds!");
            System.out.println("Available funds (Balance + Overdraft): " + availableFunds);
        }
    }
    
    // Override displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   CURRENT ACCOUNT DETAILS              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Account Number: " + String.format("%-21s", accountNumber) + "║");
        System.out.println("║ Account Holder: " + String.format("%-21s", accountHolder) + "║");
        System.out.println("║ Balance: $" + String.format("%-30.2f", balance) + "║");
        System.out.println("║ Interest Rate: " + String.format("%-21.2f%%", interestRate) + "║");
        System.out.println("║ Overdraft Limit: $" + String.format("%-25.2f", overdraftLimit) + "║");
        System.out.println("║ Overdraft Charge: $" + String.format("%-24.2f", overdraftCharge) + "║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    // Getter methods
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public double getOverdraftCharge() {
        return overdraftCharge;
    }
}