package model;

public class Customer {
	
	private String name;
	private String cpf;
	
	private Account bankAccount;
	
	
	public Customer(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer [name= " + name + "\n" +
				"cpf = " + cpf + "]";
	}

	
	
	
}
