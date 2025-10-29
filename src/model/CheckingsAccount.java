package model;

public class CheckingsAccount extends Account{

	public CheckingsAccount(String accountNumber, String agencyNumber, Customer consumer, Double accountBalance,
			Double transferLimit) {
		super(accountNumber, agencyNumber, consumer, accountBalance, transferLimit);
	}

	@Override
	public void withdraw(Double amount) {
		if(amount < 0) throw new IllegalArgumentException("invalid withdraw");
		
		if (amount < getAccountBalance() && amount < getTransferLimit()) {
			setAccountBalance(getAccountBalance() - amount);
			addTransaction(new Transaction("SAQUE", amount, this, null));
		} else {
			System.out.println("Insufficient funds or Limit exceeded, try again with another value.");
		}

	
}
}
