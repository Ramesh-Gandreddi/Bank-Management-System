import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        Account newAccount = new Account(accountNumber, name, balance);
        accounts.put(accountNumber, newAccount);

        System.out.println("Account created successfully!");
    }

    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAccountDetails() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.displayBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void runBank() {
        int choice;
        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    displayAccountDetails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}
