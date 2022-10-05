package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transaction_details")
public class ITransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	private double amount;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transactionId",unique=true)
	@JsonBackReference
    IPayment payment;
	
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
	
	public IPayment getPayment() {
		return payment;
	}

	public void setP(IPayment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ITransaction [transactionId=" + transactionId + ", amount=" + amount + ", payment=" + payment + "]";
	}
}

