package com.service;

import java.lang.StackWalker.Option;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.RoomDetails;
import com.repository.RoomDetailsRepo;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {
	
	@Autowired
	RoomDetailsRepo repo;
	
	public RoomDetails addRoomDetails(RoomDetails roomDetails)
	{
		
		repo.save(roomDetails);
		return roomDetails;
		
	}
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails)
	{
		
		int id=roomDetails.getRoom_id();
		RoomDetails rd1= repo.findById(id).orElseThrow();
		
		rd1.setRoom_id(roomDetails.getRoom_id());
		rd1.setHotel_id(roomDetails.getHotel_id());
		rd1.setRoom_no(roomDetails.getRoom_no());
		rd1.setRoom_type(roomDetails.getRoom_type());
		rd1.setRate_per_day(roomDetails.getRate_per_day());
		rd1.setIsavailable(roomDetails.getIsavailable());
		
		repo.save(roomDetails);
		return rd1;
	}
	
	public RoomDetails removeRoomDetails(RoomDetails roomDetails)
	{
		repo.delete(roomDetails);
		return roomDetails;
	}

	public List<RoomDetails> showAllRoomDetails()
	{
		return repo.findAll();
	}
	
	public RoomDetails showRoomDetails(int id)
	{
		Optional roomOpt=repo.findById(id);
		RoomDetails roomdetails= (RoomDetails) roomOpt.get();
		
		return roomdetails;
	}
	
//	public List<RoomDetails> getRoomDetailsByRoomType(String room_type)
//	{
//		return repo.getRoomDetailsByRoomType(room_type);
//		
//	}
	
}
