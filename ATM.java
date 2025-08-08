
import java.util.Scanner;

public class ATM {

    private BankAccount Account; 

    public ATM(BankAccount account) {
        this.Account = account;
    }

    public void displayMenu() {
        System.out.println("\n ATM Interface");
        System.out.println("1. Withdraw amount");
        System.out.println("2. Deposit amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter  choice: ");
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("OOPS!Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else if (Account.getBalance() >= amount) {
            Account.withdraw(amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + String.format("%.2f", Account.getBalance()));
        } else {
            System.out.println("Insufficient balance. Current balance: $" + String.format("%.2f", Account.getBalance()));
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount,Please enter a positive value.");
        } else {
            Account.deposit(amount);
            System.out.println("Deposit successful, New balance: $" + String.format("%.2f", Account.getBalance()));
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", Account.getBalance()));
    }

    public static void main(String[] args) {
        // Create a user's bank account with an initial balance
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000

        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(account);

        // Run the ATM interface
        atm.run();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}

