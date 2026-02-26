import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  WELCOME TO BANKING SYSTEM             ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // Create accounts with initial values
        SavingsAccount savingsAccount = new SavingsAccount("SA001", "John Doe", 5000, 5, 1000);
        CurrentAccount currentAccount = new CurrentAccount("CA001", "Jane Smith", 10000, 2, 5000);
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    manageSavingsAccount(savingsAccount);
                    break;
                case 2:
                    manageCurrentAccount(currentAccount);
                    break;
                case 3:
                    System.out.println("\n👋 Thank you for using our Banking System!");
                    running = false;
                    break;
                default:
                    System.out.println("✗ Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
    
    public static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          MAIN MENU                     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Manage Savings Account              ║");
        System.out.println("║ 2. Manage Current Account              ║");
        System.out.println("║ 3. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");
    }
    
    public static void manageSavingsAccount(SavingsAccount account) {
        boolean managing = true;
        while (managing) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║     SAVINGS ACCOUNT OPERATIONS         ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. View Account Details                ║");
            System.out.println("║ 2. Deposit Money                       ║");
            System.out.println("║ 3. Withdraw Money                      ║");
            System.out.println("║ 4. Add Interest                        ║");
            System.out.println("║ 5. Set Interest Rate                   ║");
            System.out.println("║ 6. Set Minimum Balance                 ║");
            System.out.println("║ 7. Set Penalty Amount                  ║");
            System.out.println("║ 8. Back to Main Menu                   ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    account.deposit();
                    break;
                case 3:
                    account.withdraw();
                    break;
                case 4:
                    account.addInterest();
                    break;
                case 5:
                    account.setInterestRate();
                    break;
                case 6:
                    account.setMinimumBalance();
                    break;
                case 7:
                    account.setPenalty();
                    break;
                case 8:
                    managing = false;
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }
    
    public static void manageCurrentAccount(CurrentAccount account) {
        boolean managing = true;
        while (managing) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║     CURRENT ACCOUNT OPERATIONS         ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. View Account Details                ║");
            System.out.println("║ 2. Deposit Money                       ║");
            System.out.println("║ 3. Withdraw Money                      ║");
            System.out.println("║ 4. Add Interest                        ║");
            System.out.println("║ 5. Set Interest Rate                   ║");
            System.out.println("║ 6. Set Overdraft Limit                 ║");
            System.out.println("║ 7. Set Overdraft Charge                ║");
            System.out.println("║ 8. Back to Main Menu                   ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    account.deposit();
                    break;
                case 3:
                    account.withdraw();
                    break;
                case 4:
                    account.addInterest();
                    break;
                case 5:
                    account.setInterestRate();
                    break;
                case 6:
                    account.setOverdraftLimit();
                    break;
                case 7:
                    account.setOverdraftCharge();
                    break;
                case 8:
                    managing = false;
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }
}