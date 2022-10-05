package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.Hotel;


public interface HotelService {
    
    public Hotel addHotel(Hotel hotel);
    
    public Hotel updateHotel(Hotel hotel) throws ResourceNotFoundException;
    
    public Hotel removeHotel(Hotel hotel) throws ResourceNotFoundException;
    
    public List<Hotel> showAllHotels() throws EmptyListException;
    
    public Hotel showHotel(int id) throws ResourceNotFoundException;
    
    



}
