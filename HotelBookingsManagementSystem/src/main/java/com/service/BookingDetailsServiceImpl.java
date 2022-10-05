package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.BookingDetails;
import com.repository.IBookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements IBookingDetailsService
{
	private String message="Booking Id doesn't exist in the database";
	
	@Autowired
	private IBookingDetailsRepository bookingDetailsRepository;

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails)
	{
		return bookingDetailsRepository.save(bookingDetails);	
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) throws ResourceNotFoundException
	{
		Supplier<ResourceNotFoundException> s1=()->new ResourceNotFoundException(message);
		BookingDetails bookingDetails2=bookingDetailsRepository.findById(bookingDetails.getBookingId()).orElseThrow(s1);
		
		bookingDetails2.setNoOfAdults(bookingDetails.getNoOfAdults());
		bookingDetails2.setNoOfChildren(bookingDetails.getNoOfChildren());
		bookingDetails2.setBookedFrom(bookingDetails.getBookedFrom());
		bookingDetails2.setBookedTo(bookingDetails.getBookedTo());
		bookingDetails2.setAmount(bookingDetails.getAmount());
		
		return bookingDetailsRepository.save(bookingDetails2);
	}

	@Override
	public String removeBookingDetails(int bookingId) throws ResourceNotFoundException
	{
		Supplier<ResourceNotFoundException> s1=()->new ResourceNotFoundException(message);
		bookingDetailsRepository.findById(bookingId).orElseThrow(s1);
		bookingDetailsRepository.deleteById(bookingId);
		return "Deleted successfully";
	}

	@Override
	public BookingDetails showBookingDetails(int bookingId) throws ResourceNotFoundException
	{
		Supplier<ResourceNotFoundException> s1=()->new ResourceNotFoundException(message);
		return bookingDetailsRepository.findById(bookingId).orElseThrow(s1);
	}

	@Override
	public List<BookingDetails> showAllBookingDetails() throws EmptyListException
	{
		List<BookingDetails> bookingDetails= bookingDetailsRepository.findAll();
		if(bookingDetails.isEmpty())
		{
			throw new EmptyListException("No booking details available");
		}
		return bookingDetails;
	}
	
}

