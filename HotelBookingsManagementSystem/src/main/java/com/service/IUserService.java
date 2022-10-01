package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class IUserService implements IUserServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		int id=user.getUserId();
		User u1=userRepository.findById(id).orElseThrow();
		u1.setUserName(user.getUserName());
		u1.setEmail(user.getEmail());
		u1.setAddress(user.getAddress());
		u1.setPassword(user.getPassword());
		u1.setRole(user.getRole());
		u1.setMobile(user.getMobile());
		
		return userRepository.save(u1);
		
	}
	
	@Override
	public String removeUser(int userId) {
		userRepository.deleteById(userId);
		return "User removed successfully";
	}
	
	@Override
	public List<User> showAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User showUser(int userId){
		return userRepository.findById(userId).orElseThrow();
	}
}
