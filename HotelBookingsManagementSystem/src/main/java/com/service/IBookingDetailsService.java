package com.service;

import java.util.List;

import com.entity.BookingDetails;

public interface IBookingDetailsService 
{
	public BookingDetails addBookingDetails(BookingDetails bookingDetails);
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails);
	public String removeBookingDetails(int booking_id);
	public BookingDetails showBookingDetails(int booking_id);
	public List<BookingDetails> showAllBookingDetails();
}
