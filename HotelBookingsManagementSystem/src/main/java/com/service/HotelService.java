package com.service;

import java.util.List;

import com.entity.Hotel;

public interface HotelService {
	
	public Hotel addHotel(Hotel hotel);
	
	public Hotel updateHotel(Hotel hotel);
	
	public Hotel removeHotel(Hotel hotel);
	
	public List<Hotel> showAllHotels();
	
	public Hotel showHotel(int id);
	
	

}
