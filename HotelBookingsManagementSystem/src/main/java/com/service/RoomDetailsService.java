package com.service;

import java.util.List;

import com.entity.RoomDetails;

public interface RoomDetailsService {
	
	public RoomDetails addRoomDetails(RoomDetails roomDetails);
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails);
	
	public RoomDetails removeRoomDetails(RoomDetails roomDetails);
	
	public List<RoomDetails> showAllRoomDetails();
	
	public RoomDetails showRoomDetails(int id);

}
