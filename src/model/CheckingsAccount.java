package model;

import java.time.LocalDateTime;

public class CheckingsAccount extends Account{

	public CheckingsAccount(String accountNumber, String agencyNumber, Customer consumer, Double accountBalance,
			Double transferLimit) {
		super(accountNumber, agencyNumber, consumer, accountBalance, transferLimit);
	}

	@Override
	public void withdraw(Double amount) {
		if(amount < 0) throw new IllegalArgumentException("invalid withdraw");
		
		int hour = LocalDateTime.now().getHour();
		
		double availableLimit = getTransferLimit();
		
		if (hour >= 22) {
			availableLimit = 500;
		}
		
		
		double fee = 2.0;
		if (amount + fee < getAccountBalance() && amount < availableLimit) {
			setAccountBalance(getAccountBalance() - amount - fee);
			addTransaction(new Transaction("SAQUE", amount, this, null));
		} else {
			System.out.println("Insufficient funds or Limit exceeded, try again with another value.");
		}

	
}
}
