package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entity.IPayment;
import com.service.IPaymentService;

@RestController
@RequestMapping("/api")
public class IPaymentController {
	
	@Autowired
	IPaymentService paymentservice;
	
	@PostMapping("/addpayment")
	  public ResponseEntity<IPayment> addpayment(@Valid @RequestBody IPayment payment) 
	  { 
		  
		  return new ResponseEntity<>(paymentservice.addPayment(payment),HttpStatus.OK);
	  }
}
