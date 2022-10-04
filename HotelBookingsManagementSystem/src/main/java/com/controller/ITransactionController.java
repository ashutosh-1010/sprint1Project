package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ITransaction;
import com.service.ITransactionService;

@RestController
@RequestMapping("/api")
public class ITransactionController {

	@Autowired
	ITransactionService transactionservice;
	
	@PostMapping("/addtransaction")
	public ResponseEntity<ITransaction> addTransaction(@Valid @RequestBody ITransaction transaction) {
	
		
		return new ResponseEntity<>(transactionservice.addTransaction(transaction),HttpStatus.OK);
}
}