package com.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.entity.IPayment;
import com.entity.ITransaction;
import com.entity.RoomDetails;
import com.entity.User;
import com.repository.IPaymentRepository;
import com.service.IPaymentService;

@SpringBootTest 
class IPaymentServiceImplTest {

	@Autowired
	IPaymentService PService;
	
	@MockBean
	IPaymentRepository PRepository;
	
	@Test
	void testAddPayment() {
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
		
		BookingDetails b = new BookingDetails();
		b.setAmount(15000);
		b.setBookedFrom(null);
		b.setBookedTo(null);
		b.setBookingId(1);
		b.setHotel(h);
		b.setNoOfAdults(2);
		b.setNoOfChildren(2);
		b.setRoomDetails(r);
		b.setUser(u);
		
		ITransaction t = new ITransaction();
		t.setAmount(15000);
		t.setTransactionId(1);
		
		
		IPayment p= new IPayment();
		p.setPaymentId(1);
	
		p.setTransaction(t);
		p.setBookingDetails(b);
		
		
		Mockito.when(PRepository.save(p)).thenReturn(p);
		assertThat(PService.addPayment(p)).isEqualTo(p);
	}
	
	@Test
	void testShowAllPayment() throws Throwable {
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
		
		BookingDetails b = new BookingDetails();
		b.setAmount(15000);
		b.setBookedFrom(null);
		b.setBookedTo(null);
		b.setBookingId(1);
		b.setHotel(h);
		b.setNoOfAdults(2);
		b.setNoOfChildren(2);
		b.setRoomDetails(r);
		b.setUser(u);
		
		ITransaction t = new ITransaction();
		t.setAmount(15000);
		t.setTransactionId(1);
		
		
		IPayment p1= new IPayment();
		p1.setPaymentId(1);
	
		p1.setTransaction(t);
		p1.setBookingDetails(b);
		
		IPayment p2= new IPayment();
		p2.setPaymentId(2);
	
		p2.setTransaction(t);
		p2.setBookingDetails(b);
		
		List<IPayment> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		Mockito.when(PRepository.findAll()).thenReturn(list);
		assertThat(PService.showAllPayment()).isEqualTo(list);
		
	}
	
	@Test
	void testShowPayment() throws Throwable{
		
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
		
		BookingDetails b = new BookingDetails();
		b.setAmount(15000);
		b.setBookedFrom(null);
		b.setBookedTo(null);
		b.setBookingId(1);
		b.setHotel(h);
		b.setNoOfAdults(2);
		b.setNoOfChildren(2);
		b.setRoomDetails(r);
		b.setUser(u);
		
		ITransaction t = new ITransaction();
		t.setAmount(15000);
		t.setTransactionId(1);
		
		
		IPayment p1= new IPayment();
		p1.setPaymentId(1);
	
		p1.setTransaction(t);
		p1.setBookingDetails(b);
		
		
		Optional<IPayment> uOptional=Optional.of(p1);
		
		Mockito.when(PRepository.findById(p1.getPaymentId())).thenReturn(uOptional);
		assertThat(PService.showPayment(p1.getPaymentId())).isEqualTo(p1);
	}

}

