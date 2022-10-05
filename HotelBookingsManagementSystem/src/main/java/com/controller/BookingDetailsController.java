package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.BookingDetails;
import com.service.BookingDetailsServiceImpl;

@RestController
@RequestMapping("bookingDetails")
public class BookingDetailsController 
{
	@Autowired
	private BookingDetailsServiceImpl bookingDetailsServiceImpl;
	
	@PostMapping("addBookingDetails")
	public ResponseEntity<String> addBookingDetails(@Valid @RequestBody BookingDetails bookingDetails)
	{
		return new ResponseEntity<>(bookingDetailsServiceImpl.addBookingDetails(bookingDetails),HttpStatus.OK);
	}
	
	
	@PutMapping("updateBookingDetails")
	public ResponseEntity<BookingDetails> updateBookingDetails(@Valid @RequestBody BookingDetails bookingDetails) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(bookingDetailsServiceImpl.updateBookingDetails(bookingDetails),HttpStatus.OK)  ;
	}
	
	
	@DeleteMapping("removeBookingDetails/{bookingId}")
	public ResponseEntity<String> removeBookingDetails(@PathVariable int bookingId) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(bookingDetailsServiceImpl.removeBookingDetails(bookingId),HttpStatus.OK);
	}
	
	
	@GetMapping("showBookingDetails/{bookingId}")
	public ResponseEntity<BookingDetails> showBookingDetails(@PathVariable int bookingId) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(bookingDetailsServiceImpl.showBookingDetails(bookingId),HttpStatus.OK);
	}
	
	
	@GetMapping("showAllBookingDetails")
	public ResponseEntity<List<BookingDetails>> showAllBookingDetails() throws EmptyListException
	{
		return new ResponseEntity<>(bookingDetailsServiceImpl.showAllBookingDetails(),HttpStatus.OK);
	}
}

