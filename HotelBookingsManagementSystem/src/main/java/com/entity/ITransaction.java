package com.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="transaction")
public class ITransaction {

	@Id
	@GeneratedValue
	private int transactionId;
	private double amount;
	
	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ITransaction [transactionId=" + transactionId + ", amount=" + amount + "]";
	}

	
}
