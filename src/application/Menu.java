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

public class Menu {

	private final Scanner sc = new Scanner(System.in);
	private final List<Account> accounts = new ArrayList<>();
	private final BankService bankService = new BankService();

	public void run() {
		int option;
		do {
			System.out.println("\n=== BANK APP ===");

			if (accounts.isEmpty()) {
				System.out.println("⚠️  No accounts found. Please create an account first.\n");
				System.out.println("1 - Create Account");
				System.out.println("0 - Exit");
				System.out.print("Option: ");
				option = sc.nextInt();
				sc.nextLine();

				if (option == 1)
					createAccount();
				else if (option == 0)
					System.out.println("Exiting...");
				else
					System.out.println("Invalid option!");
				continue;
			}

			System.out.println("1 - Create Another Account");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Change Limit");
			System.out.println("5 - Export Transactions");
			System.out.println("6 - See your accounts");
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
			case 6 -> seeAccounts();
			case 0 -> System.out.println("Exiting...");
			default -> System.out.println("Invalid option!");
			}
		} while (option != 0);
	}

	private void createAccount() {
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
		Account account = (type == 1) ? new CheckingsAccount(accountNumber, agencyNumber, customer, 0.0, limit)
				: new SavingsAccount(accountNumber, agencyNumber, customer, 0.0, limit);

		accounts.add(account);

		System.out.println("\nAccount created successfully! Account data:\n\n" + account);
	}

	private void seeAccounts() {
		System.out.println("See your accounts below: ");

		System.out.println();
		accounts.forEach(System.out::println);
	}

	private void deposit() {
		Account account = findAccount();
		if (account == null)
			return;

		System.out.print("Enter amount to deposit: ");
		double amount = sc.nextDouble();

		bankService.deposit(account, amount);
		System.out.println("Successful! New balance: " + account.getAccountBalance());
	}

	private void withdraw() {
		Account account = findAccount();
		if (account == null)
			return;

		System.out.print("Enter amount to withdraw: ");
		double amount = sc.nextDouble();

		bankService.withDraw(account, amount);
		System.out.println("Balance: " + account.getAccountBalance());
	}

	private void changeLimit() {
		Account account = findAccount();
		if (account == null)
			return;

		System.out.print("Enter the new limit value: ");
		double newLimit = sc.nextDouble();

		bankService.changeLimit(account, newLimit);
		System.out.println("Successful! New limit: " + account.getTransferLimit());
	}

	private void exportTransactions() {
		Account account = findAccount();
		if (account == null)
			return;

		List<Transaction> transactions = account.getTransactions();

		if (transactions.isEmpty()) {
			System.out.println("No transactions found for this account.");
			return;
		}

		String path = "transactions_" + account.getAccountNumber() + ".csv";
		CSVExporter.export(transactions, path);

		System.out.println("Transactions exported to: " + path);
		System.out.println("\nYou can see the transactions below too:\n");
		transactions.forEach(System.out::println);
	}

	private Account findAccount() {
		System.out.print("Enter account number: ");
		String accountNumber = sc.next();

		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				return acc;
			}
		}
		System.out.println("Account not found!");
		return null;
	}
}