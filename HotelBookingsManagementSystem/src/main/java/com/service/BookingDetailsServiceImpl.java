package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BookingDetails;
import com.repository.IBookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements IBookingDetailsService
{
	@Autowired
	private IBookingDetailsRepository bookingDetailsRepository;

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails)
	{
		return bookingDetailsRepository.save(bookingDetails);	
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails)
	{
		BookingDetails bookingDetails2=bookingDetailsRepository.findById(bookingDetails.getBooking_id()).orElseThrow();
		
		bookingDetails2.setHotel_id(bookingDetails.getHotel_id());
		bookingDetails2.setRoom_id(bookingDetails.getRoom_id());
		bookingDetails2.setUser_id(bookingDetails.getUser_id());
		bookingDetails2.setNo_of_adults(bookingDetails.getNo_of_adults());
		bookingDetails2.setNo_of_children(bookingDetails.getNo_of_children());
		bookingDetails2.setBooked_from(bookingDetails.getBooked_from());
		bookingDetails2.setBooked_to(bookingDetails.getBooked_to());
		bookingDetails2.setAmount(bookingDetails.getAmount());
		
		return bookingDetailsRepository.save(bookingDetails2);
	}

	@Override
	public String removeBookingDetails(int booking_id) 
	{
		bookingDetailsRepository.deleteById(booking_id);
		return "Deleted successfully";
	}

	@Override
	public BookingDetails showBookingDetails(int booking_id) 
	{
		return bookingDetailsRepository.findById(booking_id).orElseThrow();
	}

	@Override
	public List<BookingDetails> showAllBookingDetails()
	{
		return bookingDetailsRepository.findAll();
	}
	
}
