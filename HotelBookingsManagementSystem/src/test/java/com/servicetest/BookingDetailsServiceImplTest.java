package com.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.entity.BookingDetails;
import com.entity.Hotel;
import com.entity.RoomDetails;
import com.entity.User;
import com.repository.IBookingDetailsRepository;
import com.service.BookingDetailsServiceImpl;

@SpringBootTest
class BookingDetailsServiceImplTest 
{
	@Autowired
	BookingDetailsServiceImpl bookingDetailsServiceImpl;
	
	@MockBean
	IBookingDetailsRepository bookingDetailsRepository;
	
	@Test
	void testAddBookingDetails() throws Throwable
	{
		
		BookingDetails b1=new BookingDetails();
		b1.setAmount(10000.45);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		b1.setNoOfAdults(2);
		b1.setNoOfChildren(0);
		b1.setBookingId(101);
		
		User u = new User();
		u.setAddress("Chennai");
		u.setEmail("Abi@gmail.com");
		u.setMobile("765489830");
		u.setPassword("Gowtham08@");
		u.setRole("customer");
		u.setUserId(2);
		u.setUserName("Nandhini");
		
		Hotel h = new Hotel();
		h.setAddress("Kalyaninagar,pune");
		h.setAvgRatePerDay(11000.0);
		h.setCity("Pune");
		h.setDescription("5 star hotel");
		h.setEmail("hyatt@hyattreg.com");
		h.setHotelId(1);
		h.setHotelName("Hyatt regency");
		h.setPhone1("1234567890");
		h.setPhone2("0987654321");
		h.setWebsite("hyatt.com");
		
		RoomDetails r = new RoomDetails();
		r.setHotel(h);
		r.setIsavailable(true);
		r.setRatePerDay(11000.0);
		r.setRoomId(1);
		r.setRoomNo("A-1001");
		r.setRoomType("single");
		
		b1.setHotel(h);
		b1.setUser(u);
		b1.setRoomDetails(r);
		
		Mockito.when(bookingDetailsRepository.save(b1)).thenReturn(b1);
		assertThat(bookingDetailsServiceImpl.addBookingDetails(b1)).isEqualTo("Room booked successfully");
		
	}
	
	@Test
	void testUpdateBookingDetails() throws Throwable
	{
		BookingDetails b1=new BookingDetails();
		b1.setBookingId(101);
		b1.setNoOfAdults(2);
		b1.setNoOfChildren(1);
		b1.setAmount(4500.75);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		
		User u = new User();
		u.setAddress("Chennai");
		u.setEmail("Abi@gmail.com");
		u.setMobile("765489830");
		u.setPassword("Gowtham08@");
		u.setRole("customer");
		u.setUserId(2);
		u.setUserName("Nandhini");
		
		Hotel h = new Hotel();
		h.setAddress("Kalyaninagar,pune");
		h.setAvgRatePerDay(11000.0);
		h.setCity("Pune");
		h.setDescription("5 star hotel");
		h.setEmail("hyatt@hyattreg.com");
		h.setHotelId(1);
		h.setHotelName("Hyatt regency");
		h.setPhone1("1234567890");
		h.setPhone2("0987654321");
		h.setWebsite("hyatt.com");
		
		RoomDetails r = new RoomDetails();
		r.setHotel(h);
		r.setIsavailable(true);
		r.setRatePerDay(11000.0);
		r.setRoomId(1);
		r.setRoomNo("A-1001");
		r.setRoomType("single");
		
		b1.setHotel(h);
		b1.setUser(u);
		b1.setRoomDetails(r);
		
		Optional<BookingDetails> b2=Optional.of(b1);
		
		Mockito.when(bookingDetailsRepository.findById(101)).thenReturn(b2);
		Mockito.when(bookingDetailsRepository.save(b1)).thenReturn(b1);
		
		b1.setNoOfAdults(4);
		b1.setNoOfChildren(0);
		
		assertThat(bookingDetailsServiceImpl.updateBookingDetails(b1)).isEqualTo(b1);
	}
	
	@Test
	void testRemoveBookingDetails() throws Throwable
	{
		BookingDetails b1=new BookingDetails();
		b1.setBookingId(101);
		b1.setNoOfAdults(2);
		b1.setNoOfChildren(1);
		b1.setAmount(4500.75);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		
		User u = new User();
		u.setAddress("Chennai");
		u.setEmail("Abi@gmail.com");
		u.setMobile("765489830");
		u.setPassword("Gowtham08@");
		u.setRole("customer");
		u.setUserId(2);
		u.setUserName("Nandhini");
		
		Hotel h = new Hotel();
		h.setAddress("Kalyaninagar,pune");
		h.setAvgRatePerDay(11000.0);
		h.setCity("Pune");
		h.setDescription("5 star hotel");
		h.setEmail("hyatt@hyattreg.com");
		h.setHotelId(1);
		h.setHotelName("Hyatt regency");
		h.setPhone1("1234567890");
		h.setPhone2("0987654321");
		h.setWebsite("hyatt.com");
		
		RoomDetails r = new RoomDetails();
		r.setHotel(h);
		r.setIsavailable(true);
		r.setRatePerDay(11000.0);
		r.setRoomId(1);
		r.setRoomNo("A-1001");
		r.setRoomType("single");
		
		b1.setHotel(h);
		b1.setUser(u);
		b1.setRoomDetails(r);
		
		Optional<BookingDetails> b2=Optional.of(b1);
		
		Mockito.when(bookingDetailsRepository.findById(1)).thenReturn(b2);
		Mockito.when(bookingDetailsRepository.existsById(b1.getBookingId())).thenReturn(false);
		
		assertFalse(bookingDetailsRepository.existsById(b1.getBookingId()));
	}
	
	@Test
	void testShowBookingDetails() throws Throwable
	{

		BookingDetails b1=new BookingDetails();
		b1.setBookingId(101);
		b1.setNoOfAdults(2);
		b1.setNoOfChildren(1);
		b1.setAmount(4500.75);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		
		User u = new User();
		u.setAddress("Chennai");
		u.setEmail("Abi@gmail.com");
		u.setMobile("765489830");
		u.setPassword("Gowtham08@");
		u.setRole("customer");
		u.setUserId(2);
		u.setUserName("Nandhini");
		
		Hotel h = new Hotel();
		h.setAddress("Kalyaninagar,pune");
		h.setAvgRatePerDay(11000.0);
		h.setCity("Pune");
		h.setDescription("5 star hotel");
		h.setEmail("hyatt@hyattreg.com");
		h.setHotelId(1);
		h.setHotelName("Hyatt regency");
		h.setPhone1("1234567890");
		h.setPhone2("0987654321");
		h.setWebsite("hyatt.com");
		
		RoomDetails r = new RoomDetails();
		r.setHotel(h);
		r.setIsavailable(true);
		r.setRatePerDay(11000.0);
		r.setRoomId(1);
		r.setRoomNo("A-1001");
		r.setRoomType("single");
		
		b1.setHotel(h);
		b1.setUser(u);
		b1.setRoomDetails(r);
		
		Optional<BookingDetails> b2=Optional.of(b1);
		

		Mockito.when(bookingDetailsRepository.findById(b1.getBookingId())).thenReturn(b2);
		assertThat(bookingDetailsServiceImpl.showBookingDetails(b1.getBookingId())).isEqualTo(b1);
	}
	
	@Test
	void testShowAllBookingDetails() throws Throwable
	{
		
		BookingDetails b1=new BookingDetails();
		b1.setBookingId(101);
		b1.setNoOfAdults(2);
		b1.setNoOfChildren(1);
		b1.setAmount(4500.75);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		
		BookingDetails b2=new BookingDetails();
		b1.setBookingId(102);
		b1.setNoOfAdults(3);
		b1.setNoOfChildren(2);
		b1.setAmount(5580.75);
		b1.setBookedFrom("2022-07-22");
		b1.setBookedTo("2022-07-25");
		
		User u = new User();
		u.setAddress("Chennai");
		u.setEmail("Abi@gmail.com");
		u.setMobile("765489830");
		u.setPassword("Gowtham08@");
		u.setRole("customer");
		u.setUserId(2);
		u.setUserName("Nandhini");
		
		Hotel h = new Hotel();
		h.setAddress("Kalyaninagar,pune");
		h.setAvgRatePerDay(11000.0);
		h.setCity("Pune");
		h.setDescription("5 star hotel");
		h.setEmail("hyatt@hyattreg.com");
		h.setHotelId(1);
		h.setHotelName("Hyatt regency");
		h.setPhone1("1234567890");
		h.setPhone2("0987654321");
		h.setWebsite("hyatt.com");
		
		RoomDetails r = new RoomDetails();
		r.setHotel(h);
		r.setIsavailable(true);
		r.setRatePerDay(11000.0);
		r.setRoomId(1);
		r.setRoomNo("A-1001");
		r.setRoomType("single");
		
		b1.setHotel(h);
		b1.setUser(u);
		b1.setRoomDetails(r);
		
		List<BookingDetails> bookings=new ArrayList<>();
		bookings.add(b1);
		bookings.add(b2);
		
		Mockito.when(bookingDetailsRepository.findAll()).thenReturn(bookings);
		assertThat(bookingDetailsServiceImpl.showAllBookingDetails()).isEqualTo(bookings);
	}
}

