package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.IPayment;
import com.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService {

	
	@Autowired
	IPaymentRepository repo;
	@Override
	public IPayment addPayment(IPayment payment)
	{
		
	    return repo.save(payment);
		
	}

}
