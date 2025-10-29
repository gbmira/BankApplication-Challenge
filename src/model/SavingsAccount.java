package model;

public class SavingsAccount extends Account{

	public SavingsAccount(String accountNumber, String agencyNumber, Customer consumer, Double accountBalance,
			Double transferLimit) {
		super(accountNumber, agencyNumber, consumer, accountBalance, transferLimit);
	}
	
	@Override
	public void deposit(Double amount) {
		super.deposit(amount);
		double interest = amount * 0.005;
	    setAccountBalance(getAccountBalance() + interest);
	}

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

