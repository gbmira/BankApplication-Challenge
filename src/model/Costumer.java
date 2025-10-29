package model;

public class Costumer {
	
	private int id;
	private String name;
	private Account bankAccount;
	
	
	public Costumer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Consumer [id=" + id + ", name=" + name + ", bankAccount=" + bankAccount + "]";
	}
	
	
	
}
