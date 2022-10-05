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
@Table(name="payment")
public class IPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;

	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="transactionId",unique = true)
	@JsonBackReference
	ITransaction transaction;
	
	
	@OneToOne
	@JoinColumn(name="bookingId")
	BookingDetails bookingDetails;
	
	
	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	public ITransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(ITransaction transaction) {
		this.transaction = transaction;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "IPayment [paymentId=" + paymentId + "]";
	}
}
