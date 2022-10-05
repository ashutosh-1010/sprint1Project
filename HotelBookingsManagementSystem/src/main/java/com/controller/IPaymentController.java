package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.IPayment;
import com.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class IPaymentController {
	
	@Autowired
	IPaymentService paymentservice;
	
	@PostMapping("/addpayment")
	  public ResponseEntity<IPayment> addpayment(@Valid @RequestBody IPayment payment) 
	  { 
		  
		  return new ResponseEntity<>(paymentservice.addPayment(payment),HttpStatus.OK);
	  }
	
	@GetMapping("/showpayments")
	public ResponseEntity<List<IPayment>> showAllUsers() throws EmptyListException{
		return new ResponseEntity<>(paymentservice.showAllPayment(),HttpStatus.OK);
	}
	
	@GetMapping("/showpayment/{id}")
	public ResponseEntity<IPayment> showUser(@PathVariable  int id) throws ResourceNotFoundException {
		return new ResponseEntity<>(paymentservice.showPayment(id),HttpStatus.OK);
	}
}
