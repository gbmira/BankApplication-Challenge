package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.Account;
import model.CheckingsAccount;
import model.Customer;
import model.SavingsAccount;
import model.Transaction;
import service.BankService;
import util.CSVExporter;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	private static BankService bankService = new BankService();

	public static void main(String[] args) {
		int option;
		do {
			System.out.println("\n=== BANK APP ===");
			System.out.println("1 - Create Account");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Change Limit");
			System.out.println("5 - Export Transactions");
			// System.out.println("6 - Transfer");
			System.out.println("0 - Exit");
			System.out.print("Option: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1 -> createAccount();
			case 2 -> deposit();
			case 3 -> withdraw();
			case 4 -> changeLimit();
			case 5 -> exportTransactions();
			//case 6 -> transfer();
			case 0 -> System.out.println("Exiting...");
			default -> System.out.println("Invalid option!");
			}
		} while (option != 0);
	}

	private static void createAccount() {
		System.out.print("Customer name: ");
		String name = sc.nextLine();
		System.out.print("Customer CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Account type (1-Checking, 2-Savings): ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Limit: ");
		double limit = sc.nextDouble();
		sc.nextLine();

		String accountNumber = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
		String agencyNumber = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));

		Customer customer = new Customer(name, cpf);
		Account account;

		if (type == 1) {
			account = new CheckingsAccount(accountNumber, agencyNumber, customer, 0.0, limit);
		} else {
			account = new SavingsAccount(accountNumber, agencyNumber, customer, 0.0, limit);
		}

		accounts.add(account);

		System.out.println();
		System.out.println("Account created successfully! Account data: \n\n" + account);
	}

	private static void deposit() {

		System.out.println("Enter account number: ");
		String accountNumber = sc.next();

		Account foundAccount = null;

		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				foundAccount = acc;
				break;
			}
		}

		if (foundAccount == null) {
			System.out.println("Account not found!");
			return;
		}

		System.out.println("Enter amount to deposit: ");
		double amount = sc.nextDouble();

		bankService.deposit(foundAccount, amount);

		System.out.println("Successful! New balance: " + foundAccount.getAccountBalance());
	}

	private static void withdraw() {

		System.out.println("Enter account number: ");
		String accountNumber = sc.next();

		Account foundAccount = null;

		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				foundAccount = acc;
				break;
			}
		}

		if (foundAccount == null) {
			System.out.println("Account not found!");
			return;
		}

		System.out.println("Enter amount to withdraw: ");
		double amount = sc.nextDouble();

		bankService.withDraw(foundAccount, amount);

		System.out.println("balance: " + foundAccount.getAccountBalance());
	}

	private static void changeLimit() {

		System.out.println("Enter account number: ");
		String accountNumber = sc.next();

		Account foundAccount = null;

		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				foundAccount = acc;
				break;
			}
		}

		if (foundAccount == null) {
			System.out.println("Account not found!");
			return;
		}

		System.out.println("Enter the new limit value: ");
		double newLimit = sc.nextDouble();

		bankService.changeLimit(foundAccount, newLimit);

		System.out.println("Successful! New limit: " + foundAccount.getTransferLimit());
	}

	private static void exportTransactions() {

		System.out.println("Enter account number: ");
		String accountNumber = sc.next();

		Account foundAccount = null;

		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				foundAccount = acc;
				break;
			}
		}

		if (foundAccount == null) {
			System.out.println("Account not found!");
			return;
		}

		System.out.println("Transactions: ");
		List<Transaction> transactions = foundAccount.getTransactions();

		if (transactions.isEmpty()) {
			System.out.println("No transactions found for this account.");
			return;
		}

		String path = "transactions_" + accountNumber + ".csv";

		CSVExporter.export(transactions, path);

		System.out.println("Transactions exported to: " + path);

		System.out.println();
		System.out.println("You can see the transactions below too: \n");

		for (Transaction t : transactions) {
			System.out.println(t);
		}
	}
}