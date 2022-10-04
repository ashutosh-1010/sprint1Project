package com.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="transaction")
public class ITransaction {

	@Id
	@Min(value=1,message="Transaction id should be greater than 0")
	private int tId;
	@Min(value=10000,message="Amount should be greater than Ten Thousand")
	private double amount;
	
	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ITransaction [tId=" + tId + ", amount=" + amount + "]";
	}

	
}
