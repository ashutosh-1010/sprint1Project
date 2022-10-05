package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.IPayment;
import com.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService {

	private String message="payment id is not available";
	
	@Autowired
	IPaymentRepository repo;
	@Override
	public IPayment addPayment(IPayment payment)
	{
		
	    return repo.save(payment);
		
	}
	@Override
	public List<IPayment> showAllPayment() throws EmptyListException {
		List<IPayment> payments=repo.findAll();
		if(payments.isEmpty()) {
			throw new EmptyListException("Payment details is empty");
		}
		return payments;
	}
	
	@Override
	public IPayment showPayment(int id) throws ResourceNotFoundException {
		Supplier<ResourceNotFoundException> s1=()-> new ResourceNotFoundException(message);
		return repo.findById(id).orElseThrow(s1);
	}
	
	@Override
	public String removePayment(int paymentId) throws ResourceNotFoundException {
		Supplier<ResourceNotFoundException> s1=()-> new ResourceNotFoundException(message);
		repo.findById(paymentId).orElseThrow(s1);
		repo.deleteById(paymentId);
		return "Payment cancelled";
	}

}
