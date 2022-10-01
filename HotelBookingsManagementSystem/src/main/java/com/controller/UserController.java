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

import com.entity.User;
import com.service.IUserService;

@RestController
@RequestMapping("User")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("adduser")
	public ResponseEntity<User> addUser(@Valid  @RequestBody User user){
		userService.addUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("updateuser")
	public ResponseEntity<User> updateUser(@Valid   @RequestBody   User user) {
		return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping("removeuser/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable int userId) {
		return new ResponseEntity<>(userService.removeUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("showusers")
	public ResponseEntity<List<User>> showAllUsers(){
		return new ResponseEntity<>(userService.showAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("showuser/{userId}")
	public ResponseEntity<User> showUser(@PathVariable  int userId) {
		return new ResponseEntity<>(userService.showUser(userId),HttpStatus.OK);
	}
	
}
