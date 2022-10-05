package com.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.RoomDetails;
import com.service.RoomDetailsService;

@RestController
@RequestMapping("/roomDetails")
public class RoomDetailsController {
	
	@Autowired
	RoomDetailsService roomDetailsService;
	
	@PostMapping("/addroomdetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@Valid @RequestBody RoomDetails roomDetails)
	{	
		 return new ResponseEntity<>(roomDetailsService.addRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@PutMapping("/updateroomdetails")
	public ResponseEntity<RoomDetails> updateRoomDetails(@Valid @RequestBody RoomDetails roomDetails) throws ResourceNotFoundException
	{	
		return new ResponseEntity<>(roomDetailsService.updateRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeroomdetails")
	public ResponseEntity<String> removeDetails(@RequestBody RoomDetails roomDetails) throws ResourceNotFoundException
	{	
		return new ResponseEntity<>(roomDetailsService.removeRoomDetails(roomDetails),HttpStatus.OK);
	}
	
	@GetMapping("/showroomdetails/{id}")
	public ResponseEntity<RoomDetails> showRoomDetails(@PathVariable int id) throws ResourceNotFoundException
	{	
		return new ResponseEntity<>(roomDetailsService.showRoomDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/showroomdetails")
	public ResponseEntity<List<RoomDetails>> showAllRoomDetails() throws EmptyListException
	{
		return new ResponseEntity<>(roomDetailsService.showAllRoomDetails(),HttpStatus.OK);
	}
}

