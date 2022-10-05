package com.service;

import java.util.List;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.RoomDetails;
import com.repository.RoomDetailsRepository;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {
	
	private String message="Roomdetails does not exist in the database";
	
	@Autowired
	RoomDetailsRepository roomDetailsRepository;
	
	public RoomDetails addRoomDetails(RoomDetails roomDetails)
	{
		return roomDetailsRepository.save(roomDetails);
	}
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) throws ResourceNotFoundException
	{
		
		int id=roomDetails.getRoomId();
		Supplier<ResourceNotFoundException> s1= ()->new ResourceNotFoundException("RoomId " +id+" does not exist in the database");
		RoomDetails rd1= roomDetailsRepository.findById(id).orElseThrow(s1);
		
		rd1.setRoomId(roomDetails.getRoomId());
		rd1.setRoomNo(roomDetails.getRoomNo());
		rd1.setRoomType(roomDetails.getRoomType());
		rd1.setRatePerDay(roomDetails.getRatePerDay());
		rd1.setIsavailable(roomDetails.getIsavailable());
		
		return roomDetailsRepository.save(roomDetails);
	}
	
	public String removeRoomDetails(RoomDetails roomDetails) throws ResourceNotFoundException
	{
		Supplier<ResourceNotFoundException> s1= ()->new ResourceNotFoundException(message);
		roomDetailsRepository.findById(roomDetails.getRoomId()).orElseThrow(s1);
		roomDetailsRepository.delete(roomDetails);
		return "Room removed";
	}

	public List<RoomDetails> showAllRoomDetails() throws EmptyListException
	{
		List<RoomDetails> roomDetails= roomDetailsRepository.findAll();
		if(roomDetails.isEmpty())
		{
			throw new EmptyListException("No room details available");
		}
		return roomDetails;
	}
	
	public RoomDetails showRoomDetails(int id) throws ResourceNotFoundException
	{
		Supplier<ResourceNotFoundException> s1= ()->new ResourceNotFoundException(message);
		return roomDetailsRepository.findById(id).orElseThrow(s1);
	}	
}

