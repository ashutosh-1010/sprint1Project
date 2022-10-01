package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.RoomDetails;

@Repository
public interface RoomDetailsRepo extends JpaRepository<RoomDetails, Integer>{
	
	
	//public List<RoomDetails> getRoomDetailsByRoomType(String room_type);
}
