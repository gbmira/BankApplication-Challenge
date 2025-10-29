package model;

import java.time.LocalDateTime;

public class Transaction {

	private LocalDateTime timestamp;
	private String type;
	private Double amount;
	private Account source;
	private Account destination;

	public Transaction(String type, Double amount, Account source, Account destination) {
		this.timestamp = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
		this.source = source;
		this.destination = destination;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getSource() {
		return source;
	}

	public void setSource(Account source) {
		this.source = source;
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Transaction [timestamp=" + timestamp + ", type=" + type + ", amount=" + amount + ", source=" + source
				+ ", destination=" + destination + "]";
	}

}
