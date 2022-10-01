package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoomDetails;
import com.service.RoomDetailsService;

@RestController
@RequestMapping("/api")
public class RoomDetailsController {
	Log logger=LogFactory.getLog(RoomDetailsController.class);
	
	@Autowired
	RoomDetailsService roomdetailsservice;
	
	@PostMapping("/addroomdetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@Valid @RequestBody RoomDetails roomDetails)
	{
		//return roomdetailsservice.addRoomDetails(roomDetails);
		 return new ResponseEntity<>(roomdetailsservice.addRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@PutMapping("/updateroomdetails")
	public ResponseEntity<RoomDetails> updateRoomDetails(@Valid @RequestBody RoomDetails roomDetails)
	{
		//return roomdetailsservice.updateRoomDetails(roomDetails);
		return new ResponseEntity<>(roomdetailsservice.updateRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeroomdetails")
	public ResponseEntity<RoomDetails> removeDetails(@RequestBody RoomDetails roomDetails)
	{
		//return roomdetailsservice.removeRoomDetails(roomDetails);
		return new ResponseEntity<>(roomdetailsservice.removeRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@GetMapping("/showroomdetails/{id}")
	public ResponseEntity<RoomDetails> showRoomDetails(@PathVariable int id)
	{
		//return roomdetailsservice.showRoomDetails(id);
		return new ResponseEntity<>(roomdetailsservice.showRoomDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/showroomdetails")
	public ResponseEntity<List<RoomDetails>> showAllRoomDetails()
	{
		//return roomdetailsservice.showAllRoomDetails();
		return new ResponseEntity<List<RoomDetails>>(roomdetailsservice.showAllRoomDetails(),HttpStatus.OK);
	}
	
//	@GetMapping("/getroomdetailsbyroomtype/{room_type}")
//	public List<RoomDetails> getRoomDetailsByRoomType(@PathVariable String room_type)
//	{
//		return roomdetailsservice.getRoomDetailsByRoomType(room_type);
//		
//	}
	
}
