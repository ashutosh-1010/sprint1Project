package com.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.BookingDetails;
import com.entity.RoomDetails;
import com.repository.IBookingDetailsRepository;
import com.repository.RoomDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements IBookingDetailsService
{
	private String message="Booking Id doesn't exist in the database";
	
	@Autowired
	private IBookingDetailsRepository bookingDetailsRepository;
	
	@Autowired
	private RoomDetailsRepository roomDetailsRepository;
	
	@Override
	public String addBookingDetails(BookingDetails bookingDetails)
	{
		if(isRoomIdPresent(bookingDetails) && (isBooked(bookingDetails))) {
			bookingDetails.setAmount(calculateTotalAmount(bookingDetails));
			bookingDetailsRepository.save(bookingDetails);
			return "Room booked successfully";
		}
		return "Room cannot be booked";
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

	@Override
	public double calculateTotalAmount(BookingDetails bookingDetails) {
		LocalDate dateBefore = LocalDate.parse(bookingDetails.getBookedFrom());
		LocalDate dateAfter = LocalDate.parse(bookingDetails.getBookedTo());
		
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(dateBefore, dateAfter);
		Optional<RoomDetails> bDetails=roomDetailsRepository.findById(bookingDetails.getRoomDetails().getRoomId());
		
		
		return noOfDaysBetween*bDetails.get().getRatePerDay();
	}

	@Override
	public boolean isRoomIdPresent(BookingDetails bookingDetails) {
		Optional<RoomDetails> bDetails=roomDetailsRepository.findById(bookingDetails.getRoomDetails().getRoomId());
		if(bDetails.isPresent()) {
			if(bDetails.get().getHotel().getHotelId()== bookingDetails.getHotel().getHotelId()) {
				if(bDetails.get().getIsavailable()) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	
	  @Override 
	  public boolean isBooked(BookingDetails bookingDetails) { 
		  LocalDate bookingfrom = LocalDate.parse(bookingDetails.getBookedFrom()); //current booking start date(22)
		  LocalDate bookingto = LocalDate.parse(bookingDetails.getBookedTo());  //current booking end date(25)
		  
		  List<BookingDetails> list= bookingDetailsRepository.findAll();
		  for(BookingDetails bDetails:list) {
			 LocalDate start= LocalDate.parse(bDetails.getBookedFrom());   //database booking start date(18)
			 LocalDate end= LocalDate.parse(bDetails.getBookedTo());       //database booking ends date(23)
			 if(bDetails.getRoomDetails().getRoomId()==bookingDetails.getRoomDetails().getRoomId()) {
				 if(bookingfrom.compareTo(start)>=0 || bookingto.compareTo(start)>=0) {
					 if(bookingfrom.compareTo(end)<=0 || bookingto.compareTo(end)<=0) {
						 return false;
					 }
					 return true;
				 }
			 }
		  }
		  return true;
	  } 
}

