package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.BookingDetails;

public interface IBookingDetailsService 
{
	public BookingDetails addBookingDetails(BookingDetails bookingDetails);
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) throws ResourceNotFoundException;
	public String removeBookingDetails(int bookingId) throws ResourceNotFoundException;
	public BookingDetails showBookingDetails(int bookingId) throws ResourceNotFoundException;
	public List<BookingDetails> showAllBookingDetails() throws EmptyListException;
}
