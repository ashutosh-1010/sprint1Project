package com.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.repository.RoomDetailsRepository;
import com.service.RoomDetailsServiceImpl;
import com.advices.EmptyListException;
import com.entity.Hotel;
import com.entity.RoomDetails;

@SpringBootTest
class RoomDetailsServiceImplTest {

	@Autowired
	RoomDetailsServiceImpl roomdetailsservice;
	
	@MockBean
	RoomDetailsRepository roomDetailsRepository;
	
	@Test
	void testAddRoomDetails() {
		RoomDetails rd1=new RoomDetails();
		rd1.setRoomId(1);
		rd1.setRoomNo("A-1001");
		rd1.setRoomType("Single");
		rd1.setRatePerDay(1000);
		rd1.setIsavailable(true);
		
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
		
		rd1.setHotel(h);
		
		Mockito.when(roomDetailsRepository.save(rd1)).thenReturn(rd1);
		assertThat(roomdetailsservice.addRoomDetails(rd1)).isEqualTo(rd1);
		
	}

	@Test
	void testUpdateRoomDetails() throws Throwable {
		RoomDetails rd1=new RoomDetails();
		rd1.setRoomId(1);
		rd1.setRoomNo("A-1001");
		rd1.setRoomType("Single");
		rd1.setRatePerDay(1000);
		rd1.setIsavailable(true);
		
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
		
		rd1.setHotel(h);
		
		Optional<RoomDetails> rOpt=Optional.of(rd1);
		
		Mockito.when(roomDetailsRepository.findById(1)).thenReturn(rOpt);
		Mockito.when(roomDetailsRepository.save(rd1)).thenReturn(rd1);
		
		rd1.setRoomType("Double");
		
		assertThat(roomdetailsservice.updateRoomDetails(rd1)).isEqualTo(rd1);
	}

	@Test
	void testRemoveRoomDetails() {
		RoomDetails rd1=new RoomDetails();
		rd1.setRoomId(1);
		rd1.setRoomNo("A-1001");
		rd1.setRoomType("Single");
		rd1.setRatePerDay(1000);
		rd1.setIsavailable(true);
		
		Optional<RoomDetails> rOpt=Optional.of(rd1);
		Mockito.when(roomDetailsRepository.findById(1)).thenReturn(rOpt);
	    Mockito.when(roomDetailsRepository.existsById(rd1.getRoomId())).thenReturn(false);
	    assertFalse(roomDetailsRepository.existsById(rd1.getRoomId()));
	}

	@Test
	void testShowAllRoomDetails() throws EmptyListException {
		RoomDetails rd1=new RoomDetails();
		rd1.setRoomId(1);
		rd1.setRoomNo("A-1001");
		rd1.setRoomType("Single");
		rd1.setRatePerDay(1000);
		rd1.setIsavailable(true);
		
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
		
		RoomDetails rd2=new RoomDetails();
		rd2.setRoomId(2);
		rd2.setRoomNo("A-1002");
		rd2.setRoomType("Double");
		rd2.setRatePerDay(2000);
		rd2.setIsavailable(true);
		
		rd1.setHotel(h);
		rd2.setHotel(h);
		
		 List<RoomDetails> roomdList = new ArrayList<>();
	        roomdList.add(rd1);
	        roomdList.add(rd2);
	        Mockito.when(roomDetailsRepository.findAll()).thenReturn(roomdList);
	        
	        assertThat(roomdetailsservice.showAllRoomDetails()).isEqualTo(roomdList);
	}

	@Test
	void testShowRoomDetails() throws Throwable {
		RoomDetails rd1=new RoomDetails();
		rd1.setRoomId(1);
		rd1.setRoomNo("A-1001");
		rd1.setRoomType("Single");
		rd1.setRatePerDay(1000);
		rd1.setIsavailable(true);
		
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
		
		rd1.setHotel(h);
		Optional<RoomDetails> rOpt = Optional.of(rd1);
        
        Mockito.when(roomDetailsRepository.findById(1)).thenReturn(rOpt);
        assertThat(roomdetailsservice.showRoomDetails(1)).isEqualTo(rd1);
        
	}

}