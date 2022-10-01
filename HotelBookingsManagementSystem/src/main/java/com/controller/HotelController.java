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

import com.entity.Hotel;
import com.service.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {
	
	
	
	@Autowired
	HotelService hotelservice;
	
	
	@PostMapping("/addhotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel)
	{
//		return hotelservice.addHotel(hotel);
		
		return new ResponseEntity<>(hotelservice.addHotel(hotel),HttpStatus.OK);
	}
	
	
	@PutMapping("/updatehotel")
	public ResponseEntity<Hotel> updateHotel(@Valid @RequestBody Hotel hotel)
	{
//		return hotelservice.updateHotel(hotel);
		return new ResponseEntity<>(hotelservice.updateHotel(hotel),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/removehotel")
	public ResponseEntity<Hotel> removeHotel(@Valid @RequestBody Hotel hotel)
	{
//		return hotelservice.removeHotel(hotel);
		return new ResponseEntity<>(hotelservice.removeHotel(hotel),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/showhotel/{id}")
	public ResponseEntity<Hotel> showHotel(@PathVariable int id)
	{
//		return hotelservice.showHotel(id);
		return new ResponseEntity<>(hotelservice.showHotel(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/showhotels")
	public ResponseEntity<List<Hotel>> showAllHotels()
	{
//		return hotelservice.showAllHotels();
		
		return new ResponseEntity<List<Hotel>>(hotelservice.showAllHotels(),HttpStatus.OK);
	}
	
	
	
	
}
