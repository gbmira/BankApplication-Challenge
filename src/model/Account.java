package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

	private Integer accountNumber;
	private Integer agencyNumber;
	private Costumer consumer;
	private Double accountBalance;
	private Double transferLimit;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Account(Integer accountNumber, Integer agencyNumber, Costumer consumer, Double accountBalance,
			Double transferLimit) {
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.consumer = consumer;
		this.accountBalance = accountBalance;
		this.transferLimit = transferLimit;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(Integer agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public Costumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Costumer consumer) {
		this.consumer = consumer;
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
		return "BankAccount [accountNumber=" + accountNumber + ", agencyNumber=" + agencyNumber + ", consumer="
				+ consumer + ", accountBalance=" + accountBalance + ", transferLimit=" + transferLimit + "]";
	}

	public void deposit(Double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit!");
			return;
		}
		
		accountBalance += amount;
		transactions.add(new Transaction("DEPOSITO", amount, this, null));
	}

	public abstract void withdraw(Double amount);

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
}
