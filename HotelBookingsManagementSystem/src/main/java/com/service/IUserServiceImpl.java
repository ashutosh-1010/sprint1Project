package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	
	private String message="userId not found";
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) throws ResourceNotFoundException{
		int id=user.getUserId();
		Supplier<ResourceNotFoundException> s1=()-> new ResourceNotFoundException(message);
		User u1=userRepository.findById(id).orElseThrow(s1);
		u1.setUserName(user.getUserName());
		u1.setEmail(user.getEmail());
		u1.setAddress(user.getAddress());
		u1.setPassword(user.getPassword());
		u1.setRole(user.getRole());
		u1.setMobile(user.getMobile());
		
		return userRepository.save(u1);
		
	}
	
	@Override
	public String removeUser(int userId) throws ResourceNotFoundException{
		Supplier<ResourceNotFoundException> s1=()-> new ResourceNotFoundException(message);
		userRepository.findById(userId).orElseThrow(s1);
		userRepository.deleteById(userId);
		return "User removed successfully";
	}
	
	@Override
	public List<User> showAllUsers() throws EmptyListException{
		List<User> userDetailsList=userRepository.findAll();
		if(userDetailsList.isEmpty()) {
			throw new EmptyListException("user details is empty");
		}
		return userRepository.findAll();
	}
	
	@Override
	public User showUser(int userId) throws ResourceNotFoundException{
		Supplier<ResourceNotFoundException> s1=()-> new ResourceNotFoundException(message);
		return userRepository.findById(userId).orElseThrow(s1);
	}
	
}
