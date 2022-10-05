package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.Hotel;
import com.repository.HotelRepository;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
	
	private String message="Hotel id does not exist in the database";
    
    @Autowired
    HotelRepository repo;
    
    @Override
    public Hotel addHotel(Hotel hotel) {
        return repo.save(hotel);
    }

   @Override
    public Hotel updateHotel(Hotel hotel) throws ResourceNotFoundException{

       int idToBeChanged = hotel.getHotelId();
        Supplier<ResourceNotFoundException> s1 = ()->new ResourceNotFoundException(message);
        
        Hotel hotel1 = repo.findById(idToBeChanged).orElseThrow(s1);
                
        hotel1.setCity(hotel.getCity());
        hotel1.setHotelName(hotel.getHotelName());
        hotel1.setAddress(hotel.getAddress());
        hotel1.setDescription(hotel.getDescription());
        hotel1.setAvgRatePerDay(hotel.getAvgRatePerDay());
        hotel1.setEmail(hotel.getEmail());
        hotel1.setPhone1(hotel.getPhone1());
        hotel1.setPhone2(hotel.getPhone2());
        hotel1.setPhone2(hotel.getPhone2());
        hotel1.setWebsite(hotel.getWebsite());
        
        return repo.save(hotel1);
       
    }
    
    @Override
    public Hotel removeHotel(Hotel hotel) throws ResourceNotFoundException{
        Supplier<ResourceNotFoundException> s1 = ()->new ResourceNotFoundException(message);
        repo.findById(hotel.getHotelId()).orElseThrow(s1);
        repo.delete(hotel);
        return hotel;
    }

   @Override
    public List<Hotel> showAllHotels() throws EmptyListException {
	   List<Hotel> hotels= repo.findAll();
		if(hotels.isEmpty())
		{
			throw new EmptyListException("No Hotel details available");
		}
		return hotels; 
    }

   @Override
    public Hotel showHotel(int id) throws ResourceNotFoundException {
        Supplier<ResourceNotFoundException> s1 = ()->new ResourceNotFoundException(message);
       return repo.findById(id).orElseThrow(s1);       
    }

}