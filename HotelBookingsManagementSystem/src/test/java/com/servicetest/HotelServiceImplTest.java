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

import com.advices.EmptyListException;
import com.entity.Hotel;
import com.repository.HotelRepository;
import com.service.HotelServiceImpl;

@SpringBootTest
class HotelServiceImplTest {
    
    @Autowired
    HotelServiceImpl hotelservice;
    
    @MockBean
    HotelRepository repo;

   @Test
    void testAddHotel() {
        Hotel h1 = new Hotel();
        h1.setHotelId(101);
        h1.setHotelName("Ibis");
        h1.setAddress("Viman Nagar");
        h1.setCity("Pune");
        h1.setAvgRatePerDay(9000);
        h1.setPhone1("12345678");
        h1.setPhone2("9876544");
        h1.setDescription("5star");
        h1.setEmail("ibis@ibisindia.com");
        h1.setWebsite("ibis.in");
        
        Mockito.when(repo.save(h1)).thenReturn(h1);
        
        assertThat(hotelservice.addHotel(h1)).isEqualTo(h1);
    }


   @Test
    void testUpdateHotel() throws Throwable {
        
        Hotel h1 = new Hotel();
        h1.setHotelId(101);
        h1.setHotelName("Ibis");
        h1.setAddress("Viman Nagar");
        h1.setCity("Pune");
        h1.setAvgRatePerDay(9000);
        h1.setPhone1("12345678");
        h1.setPhone2("9876544");
        h1.setDescription("5star");
        h1.setEmail("ibis@ibisindia.com");
        h1.setWebsite("ibis.in");
        
        Mockito.when(repo.findById(101)).thenReturn(Optional.of(h1));
        Mockito.when(repo.save(h1)).thenReturn(h1);
        h1.setAddress("Viman Nagar");
        assertThat(hotelservice.updateHotel(h1)).isEqualTo(h1);        
    }

   @Test
    void testRemoveHotel() {
	   
       Hotel h1 = new Hotel();
        h1.setHotelId(101);
        h1.setHotelName("Ibis");
        h1.setAddress("Viman Nagar");
        h1.setCity("Pune");
        h1.setAvgRatePerDay(9000);
        h1.setPhone1("12345678");
        h1.setPhone2("9876544");
        h1.setDescription("5star");
        h1.setEmail("ibis@ibisindia.com");
        h1.setWebsite("ibis.in");
        
        Mockito.when(repo.findById(101)).thenReturn(Optional.of(h1));
        Mockito.when(repo.existsById(h1.getHotelId())).thenReturn(false);
            assertFalse(repo.existsById(h1.getHotelId()));        
    }

   @Test
    void testShowAllHotels() throws EmptyListException {
        Hotel h1 = new Hotel();
        h1.setHotelId(101);
        h1.setHotelName("Ibis");
        h1.setAddress("Viman Nagar");
        h1.setCity("Pune");
        h1.setAvgRatePerDay(9000);
        h1.setPhone1("12345678");
        h1.setPhone2("9876544");
        h1.setDescription("5star");
        h1.setEmail("ibis@ibisindia.com");
        h1.setWebsite("ibis.in");
        
        
        Hotel h2 = new Hotel();
        h2.setHotelId(102);
        h2.setHotelName("Novotel");
        h2.setAddress("Viman Nagar 2");
        h2.setCity("Pune");
        h2.setAvgRatePerDay(9880);
        h2.setPhone1("34536");
        h2.setPhone2("9872144");
        h2.setDescription("5star");
        h2.setEmail("novotel@novotelindia.com");
        h2.setWebsite("novotel.in");
        
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(h1);
        hotelList.add(h2);
        Mockito.when(repo.findAll()).thenReturn(hotelList);
        
        assertThat(hotelservice.showAllHotels()).isEqualTo(hotelList);        
    }

   @Test
    void testShowHotel() throws Throwable {
        Hotel h1 = new Hotel();
        h1.setHotelId(101);
        h1.setHotelName("Ibis");
        h1.setAddress("Viman Nagar");
        h1.setCity("Pune");
        h1.setAvgRatePerDay(9000);
        h1.setPhone1("12345678");
        h1.setPhone2("9876544");
        h1.setDescription("5star");
        h1.setEmail("ibis@ibisindia.com");
        h1.setWebsite("ibis.in");
          
        Mockito.when(repo.findById(101)).thenReturn(Optional.of(h1));
        assertThat(hotelservice.showHotel(101)).isEqualTo(h1);
        
    }
}
