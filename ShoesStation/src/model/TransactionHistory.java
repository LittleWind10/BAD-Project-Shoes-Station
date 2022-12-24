package model;

import java.util.Date;

public class TransactionHistory {
	private int transactionId;
	private Date transactionDate;
	
	public TransactionHistory(int transactionId, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
