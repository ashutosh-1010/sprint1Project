package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.IPayment;

public interface IPaymentService {
	
	public IPayment addPayment(IPayment payment);
	public List<IPayment> showAllPayment() throws EmptyListException;
	public IPayment showPayment(int id) throws ResourceNotFoundException;
	public String removePayment(int paymentId) throws ResourceNotFoundException;
}