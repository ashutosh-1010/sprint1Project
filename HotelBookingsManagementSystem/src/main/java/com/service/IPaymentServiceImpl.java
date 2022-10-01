package com.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.IPayment;
import com.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService {

	
	@Autowired
	IPaymentRepository repo;
	@Override
	public IPayment addPayment(IPayment payment)
	{
		//Supplier s1 = ()->new ResourceNotFoundException("Enter valid details");
		
	    IPayment p = repo.save(payment);
		return p;
	}

}
