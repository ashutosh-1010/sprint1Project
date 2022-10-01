package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.BookingDetails;
import com.service.BookingDetailsServiceImpl;

@RestController
@RequestMapping("booking_details")
public class BookingDetailsController 
{
	@Autowired
	private BookingDetailsServiceImpl bookingDetailsServiceImpl;
	
	@PostMapping("add_booking_details")
	public BookingDetails addBookingDetails(@Valid @RequestBody BookingDetails bookingDetails)
	{
		return bookingDetailsServiceImpl.addBookingDetails(bookingDetails);
	}
	
	
	@PutMapping("update_booking_details")
	public BookingDetails updateBookingDetails(@Valid @RequestBody BookingDetails bookingDetails)
	{
		return bookingDetailsServiceImpl.updateBookingDetails(bookingDetails);
	}
	
	
	@DeleteMapping("remove_booking_details/{booking_id}")
	public String removeBookingDetails(@PathVariable int booking_id)
	{
		bookingDetailsServiceImpl.removeBookingDetails(booking_id);
		return "Deleted successfully";
	}
	
	
	@GetMapping("show_booking_details/{booking_id}")
	public BookingDetails showBookingDetails(@PathVariable int booking_id)
	{
		return bookingDetailsServiceImpl.showBookingDetails(booking_id);
	}
	
	
	@GetMapping("show_all_booking_details")
	public List<BookingDetails> showAllBookingDetails()
	{
		return bookingDetailsServiceImpl.showAllBookingDetails();
	}
}
