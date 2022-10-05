package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.RoomDetails;

public interface RoomDetailsService {
	
	public RoomDetails addRoomDetails(RoomDetails roomDetails);
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) throws ResourceNotFoundException;
	
	public String removeRoomDetails(RoomDetails roomDetails) throws ResourceNotFoundException;
	
	public List<RoomDetails> showAllRoomDetails() throws EmptyListException;
	
	public RoomDetails showRoomDetails(int id) throws ResourceNotFoundException;

}
