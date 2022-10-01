package com.service;

import java.util.List;

import com.entity.Hotel;
import com.repository.HotelRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository repo;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		repo.save(hotel);
		return hotel;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		int idToBeChanged = hotel.getHotel_id();
		Hotel hotel1 = repo.findById(idToBeChanged).orElseThrow();
		
		
		hotel1.setCity(hotel.getCity());
		hotel1.setHotel_name(hotel.getHotel_name());
		hotel1.setAddress(hotel.getAddress());
		hotel1.setDescription(hotel.getDescription());
		hotel1.setAvg_rate_per_day(hotel.getAvg_rate_per_day());
		hotel1.setEmail(hotel.getEmail());
		hotel1.setPhone1(hotel.getPhone1());
		hotel1.setPhone2(hotel.getPhone2());
		hotel1.setPhone2(hotel.getPhone2());
		hotel1.setWebsite(hotel.getWebsite());
		
		repo.save(hotel1);
		
		return hotel1;
	}
	
	@Override
	public Hotel removeHotel(Hotel hotel) {
		repo.delete(hotel);
		return hotel;
	}

	@Override
	public List<Hotel> showAllHotels() {
		return repo.findAll();
	}

	@Override
	public Hotel showHotel(int id) {
		Optional hotelOpt = repo.findById(id);
		Hotel hotel  = (Hotel) hotelOpt.get();
		
		return hotel;
	}

}
