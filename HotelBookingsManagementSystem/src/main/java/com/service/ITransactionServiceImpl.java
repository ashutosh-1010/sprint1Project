package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ITransaction;
import com.repository.ITransactionRepository;

@Service
public class ITransactionServiceImpl implements ITransactionService{

	@Autowired
	ITransactionRepository repo;
	@Override
	public ITransaction addTransaction(ITransaction transaction) {
		
		repo.save(transaction);
		return transaction;
	}

}
