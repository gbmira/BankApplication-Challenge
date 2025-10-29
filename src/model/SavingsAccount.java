package model;

public class SavingsAccount extends Account{

	public SavingsAccount(Integer accountNumber, Integer agencyNumber, Costumer consumer, Double accountBalance,
			Double transferLimit) {
		super(accountNumber, agencyNumber, consumer, accountBalance, transferLimit);
	}

	@Override
	public void deposit(Double amount) {
		// TODO Auto-generated method stub
		
	}

	public void withdraw(Double amount) {
		if(amount < 0) throw new IllegalArgumentException("invalid withdraw");
		
		if (amount < getAccountBalance() && amount < getTransferLimit()) {
			setAccountBalance(getAccountBalance() - amount);
			addTransaction(new Transaction("SAQUE", amount, this, null));
		} else {
			throw new IllegalArgumentException("Insufficient funds");
		}
	
	
}
}
