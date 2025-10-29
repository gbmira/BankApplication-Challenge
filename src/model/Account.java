package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

	private String accountNumber;
	private String agencyNumber;
	private Customer consumer;
	private Double accountBalance;
	private Double transferLimit;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String accountNumber, String agencyNumber, Customer consumer, Double accountBalance,
			Double transferLimit) {
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.consumer = consumer;
		this.accountBalance = accountBalance;
		this.transferLimit = transferLimit;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public Customer getConsumer() {
		return consumer;
	}

	public void setConsumer(Customer consumer) {
		this.consumer = consumer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getTransferLimit() {
		return transferLimit;
	}

	public void setTransferLimit(Double transferLimit) {
		this.transferLimit = transferLimit;
	}

	@Override
	public String toString() {
	    return "Account Number: " + accountNumber + "\n" +
	           "Agency Number: " + agencyNumber + "\n" +
	           "Customer: " + consumer + "\n" +
	           "Account Balance: " + accountBalance + "\n" +
	           "Transfer Limit: " + transferLimit + "\n";
	}

	public void deposit(Double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit!");
			return;
		}

		this.accountBalance += amount;
		addTransaction(new Transaction("DEPOSITO", amount, this, null));
	}

	public abstract void withdraw(Double amount);

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
}
