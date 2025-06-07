package mini_project;
import java.util.Scanner;
public class Atm {
    private static double balance = 1000.00;
    private static final String PIN = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (!enteredPin.equals(PIN)) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }

    static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
