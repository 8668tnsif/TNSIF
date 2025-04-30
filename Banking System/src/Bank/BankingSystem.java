package Bank;

import java.util.*;

public class BankingSystem {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Account> accounts = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    private static List<Beneficiary> beneficiaries = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> addAccount();
                case 3 -> addBeneficiary();
                case 4 -> addTransaction();
                case 5 -> findCustomerById();
                case 6 -> listAccountsOfCustomer();
                case 7 -> listTransactionsOfAccount();
                case 8 -> listBeneficiariesOfCustomer();
                case 9 -> {
                    System.out.println("Exiting Banking System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        customers.add(new Customer(id, name, address, contact));
        System.out.println("Customer added successfully.");
    }

    private static void addAccount() {
        System.out.print("Enter Account ID: ");
        int accountID = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        accounts.add(new Account(accountID, customerID, type, balance));
        System.out.println("Account created successfully.");
    }

    private static void addBeneficiary() {
        System.out.print("Enter Beneficiary ID: ");
        int beneficiaryID = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Beneficiary Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Beneficiary Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Bank Details: ");
        String bankDetails = scanner.nextLine();

        beneficiaries.add(new Beneficiary(beneficiaryID, customerID, name, accountNumber, bankDetails));
        System.out.println("Beneficiary added successfully.");
    }

    private static void addTransaction() {
        System.out.print("Enter Transaction ID: ");
        int transactionID = scanner.nextInt();
        System.out.print("Enter Account ID: ");
        int accountID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Transaction Type (Deposit/Withdraw/Transfer): ");
        String type = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        transactions.add(new Transaction(transactionID, accountID, type, amount));
        System.out.println("Transaction recorded successfully.");
    }

    private static void findCustomerById() {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();

        for (Customer c : customers) {
            if (c.getCustomerID() == id) {
                System.out.println("Customer Found: " + c);
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void listAccountsOfCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerID = scanner.nextInt();

        System.out.println("Accounts of Customer " + customerID + ":");
        for (Account a : accounts) {
            if (a.getCustomerID() == customerID) {
                System.out.println(a);
            }
        }
    }

    private static void listTransactionsOfAccount() {
        System.out.print("Enter Account ID: ");
        int accountID = scanner.nextInt();

        System.out.println("Transactions for Account " + accountID + ":");
        for (Transaction t : transactions) {
            if (t.getAccountID() == accountID) {
                System.out.println(t);
            }
        }
    }

    private static void listBeneficiariesOfCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerID = scanner.nextInt();

        System.out.println("Beneficiaries of Customer " + customerID + ":");
        for (Beneficiary b : beneficiaries) {
            if (b.getCustomerID() == customerID) {
                System.out.println(b);
            }
        }
    }
}

