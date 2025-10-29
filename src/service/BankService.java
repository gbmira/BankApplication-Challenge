package service;

import java.util.List;

import model.Account;
import model.Transaction;

public class BankService {
	
	public void deposit(Account account, double amount) {
		account.deposit(amount);
	}
	
	public void withDraw(Account account, double amount) {
		account.withdraw(amount);
	}
	
	public void transfer(Account from, Account to, double amount) {
		from.withdraw(amount);
		to.deposit(amount);
		
		Transaction t = new Transaction("TRANSFERENCIA", amount, from, to);
		from.addTransaction(t);
		to.addTransaction(t);
	}
	
	public void changeLimit(Account account, double newLimit) {
		account.setTransferLimit(newLimit);
	}
	
	public List<Transaction> getTransactions(Account account){
		return account.getTransactions();
	}
}
